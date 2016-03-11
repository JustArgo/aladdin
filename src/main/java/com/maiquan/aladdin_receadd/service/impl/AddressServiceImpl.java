package com.maiquan.aladdin_receadd.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiquan.aladdin_receadd.dao.impl.AddressDaoImpl;
import com.maiquan.aladdin_receadd.domain.Address;
import com.maiquan.aladdin_receadd.mapper.AddressMapper;
import com.maiquan.aladdin_receadd.service.IAddressService;
import com.maiquan.aladdin_receadd.util.LogUtil;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressDaoImpl addressDao;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public void addAddress(Address address, String requestID) {
		
		LogUtil.logInput("地区微服务", "addAddress", requestID, address);
		
		addressDao.addAddress(address);
		
		LogUtil.logOutput("地区微服务", "addAddress", requestID, "无");
	}

	@Override
	public Address getAddress(Integer id, String requestID) {
		
		LogUtil.logInput("地区微服务", "getAddress", requestID, id);
		
		Address address = addressDao.getAddress(id);
		if(address==null){
			address = addressMapper.selectByPrimaryKey(id);
			addressDao.addAddress(address);
		}
		
		LogUtil.logOutput("地区微服务", "getAddress", requestID, address);
		
		return address;
	}

	@Override
	public void addSubAddress(List<Address> addresses, String requestID) {
		
		LogUtil.logInput("地区微服务", "addSubAddress", requestID, addresses);
		
		addressDao.addSubAddress(addresses);
		
		LogUtil.logOutput("地区微服务", "addSubAddress", requestID, "无");
	}

	@Override
	public List<Address> getSubAddress(Integer pid, String requestID) {
		
		LogUtil.logInput("地区微服务", "getSubAddress", requestID, pid);
		
		List<Address> addresses = addressDao.getSubAddress(pid);
		if(addresses.size()==0){
			addresses = addressMapper.selectByPid(pid);
			addressDao.addSubAddress(addresses);
		}
		
		LogUtil.logOutput("地区微服务", "getSubAddress", requestID, addresses);
		
		return addresses;
	}

	
	
	
}
