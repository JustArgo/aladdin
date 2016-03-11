package com.maiquan.aladdin_receadd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maiquan.aladdin_receadd.domain.Address;
import com.maiquan.aladdin_receadd.service.IAddressService;

/**
 * 测试地区服务
 * @author 黄永宗
 * @date 2016年2月24日 下午2:33:19
 */
public class TestAddress {

	private IAddressService addressService = null;

	@Before
	public void setUp(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();
		addressService = (IAddressService) context.getBean("addressService");
	}
	
	/**
	 * 测试增加地区
	 */
	
	public void testAddAddress(){
		
		Address address = new Address();
		address.setId(3333);
		address.setLevel(12);
		address.setName("前");
		address.setPid(3399);
		addressService.addAddress(address,UUID.randomUUID().toString());
		Address add = addressService.getAddress(3333,"");
		Assert.assertNotNull(add);

	}
	
	/**
	 * 测试根据id查询地区
	 */
	
	public void testGetAddress(){
		
		Address add = addressService.getAddress(3333,"");
		Assert.assertNotNull(add);
		
	}
	
	/**
	 * 测试缓存某个地区的下级地区
	 */
	
	public void testAddSubAddress(){
		
		List<Address> addresses = new ArrayList<Address>();
		Address add1 = new Address();
		add1.setId(9999);
		add1.setName("中土");
		add1.setLevel(33);
		add1.setPid(99);
		
		Address add2 = new Address();
		add2.setId(9998);
		add2.setName("西方");
		add2.setLevel(33);
		add2.setPid(99);
		
		addresses.add(add1);
		addresses.add(add2);
		
		addressService.addSubAddress(addresses,"");
		
		List<Address> adds = addressService.getSubAddress(99,""); 
		Assert.assertEquals(2, adds.size());
		
	}
	
	/**
	 * 测试查询某个地区的 下级地区
	 */
	public void testGetSubAddress(){
		
		List<Address> adds = addressService.getSubAddress(99,"");
		Assert.assertEquals(2, adds.size());
		
	}
	
}
