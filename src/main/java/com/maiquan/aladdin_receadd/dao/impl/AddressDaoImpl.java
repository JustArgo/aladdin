package com.maiquan.aladdin_receadd.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Repository;

import com.maiquan.aladdin_receadd.dao.IAddressDao;
import com.maiquan.aladdin_receadd.domain.Address;
import com.maiquan.aladdin_receadd.util.ObjectToJSONSerializer;

@Repository
public class AddressDaoImpl implements IAddressDao{

	@Autowired
	private RedisTemplate<String,Address> redisTemplate;

	@Override
	public Address getAddress(Integer id) {
		
		GenericToStringSerializer<Address> serializer = new GenericToStringSerializer<Address>(Address.class);
		redisTemplate.setValueSerializer(serializer);
		Address add = new Address();
		
		HashOperations<String,String,String> operation = redisTemplate.opsForHash();
		
		Long count = operation.size("address:"+id);
		if(count==0){
			return null;
		}
		
		add.setId(id);
		add.setName((String) operation.get("address:"+id, "name"));
		add.setLevel(Integer.valueOf((String)redisTemplate.opsForHash().get("address:"+id,"level")));
		add.setPid(Integer.valueOf((String)redisTemplate.opsForHash().get("address:"+id, "pid")));
		return add;
		
	}

	@Override
	public List<Address> getSubAddress(Integer pid) {
		
		redisTemplate.setValueSerializer(new ObjectToJSONSerializer<Address>());
		
		ZSetOperations<String,Address> operation = redisTemplate.opsForZSet();
		
		List<Address> addresses = new ArrayList<Address>();
		
		//根据pid 查询下级地区的数量
		Long count = operation.zCard("pid:"+pid);
		
		if(count!=0){
			Set<TypedTuple<Address>> typedTuple = operation.rangeWithScores("pid:"+pid, 0, count-1);
			
			Iterator<TypedTuple<Address>> ite = typedTuple.iterator();
			while(ite.hasNext()){
				TypedTuple<Address> tuple = ite.next();
				addresses.add(tuple.getValue());
			}
		}
		
		return addresses;
	}

	@Override
	public void addAddress(Address address) {

		GenericToStringSerializer<Address> serializer = new GenericToStringSerializer<Address>(Address.class);
		redisTemplate.setValueSerializer(serializer);
		
		HashOperations<String,String,String> operation = redisTemplate.opsForHash();
		
		operation.put("address:"+address.getId(),"name",address.getName());
		operation.put("address:"+address.getId(),"level",address.getLevel()+"");
		operation.put("address:"+address.getId(),"pid",address.getPid()+"");
		
	}

	@Override
	public void addSubAddress(List<Address> addresses) {

		redisTemplate.setValueSerializer(new ObjectToJSONSerializer<Address>());
		ZSetOperations<String,Address> operation = redisTemplate.opsForZSet();
		for(int i=0;i<addresses.size();i++){
			operation.add("pid:"+addresses.get(0).getPid(), addresses.get(i), addresses.get(i).getId());
		}
	}
	
}
