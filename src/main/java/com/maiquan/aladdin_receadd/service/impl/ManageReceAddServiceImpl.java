package com.maiquan.aladdin_receadd.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin_receadd.domain.Address;
import com.maiquan.aladdin_receadd.domain.ReceiveAddress;
import com.maiquan.aladdin_receadd.mapper.AddressMapper;
import com.maiquan.aladdin_receadd.mapper.ReceiveAddressMapper;
import com.maiquan.aladdin_receadd.service.IManageReceAddService;
import com.maiquan.aladdin_receadd.util.LogUtil;

public class ManageReceAddServiceImpl implements IManageReceAddService{

	@Autowired
	private ReceiveAddressMapper receiveAddressMapper;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public int addAddress(ReceiveAddress receiveAddress,String requestID) {
		
		LogUtil.logInput("收货地址管理微服务","addAddress",requestID,receiveAddress);
		
		int userAddressID = (int)(Math.random()*2147483647);
		
		try{
			
			receiveAddress.setID(userAddressID);
			receiveAddress.setMqID("154");
			receiveAddress.setCreateTime(new Date());
			System.out.println("isDefault:----------------"+receiveAddress.getIsDefault());
			if(receiveAddress.getIsDefault()!=null && receiveAddress.getIsDefault().equals("DEF")){
				/* 找出原来设置的默认收货地址 并设置为非默认 如果找出来的地址和当前要设置的是同一个地址则不做任何操作 */

				ReceiveAddress defaultAddress = this.getDefaultAddress("154",UUID.randomUUID().toString());
				System.out.println(defaultAddress);
				if(defaultAddress!=null && defaultAddress.getID()!=userAddressID){
					System.out.println("---------------设置nor");
					defaultAddress.setIsDefault("NOR");
					receiveAddressMapper.updateByPrimaryKeySelective(defaultAddress);
				}
			}
			receiveAddress.setStatus("OK");
			
			receiveAddressMapper.insert(receiveAddress);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		LogUtil.logOutput("收货地址管理微服务", "addAddress", requestID, userAddressID);
		
		return userAddressID;
	}

	
	@Override
	public void updateAddress(ReceiveAddress receiveAddress,String requestID) {
		
		LogUtil.logInput("收货地址管理微服务","updateAddress",requestID,receiveAddress);
		
		try{
			receiveAddress.setUpdateTime(new Date());
			if(receiveAddress.getIsDefault()!=null && receiveAddress.getIsDefault().equals("DEF")){
				/* 找出原来设置的默认收货地址 并设置为非默认 如果找出来的地址和当前要设置的是同一个地址则不做任何操作 */
				ReceiveAddress defaultAddress = this.getDefaultAddress("154",UUID.randomUUID().toString());
				if(defaultAddress!=null && defaultAddress.getID()!=receiveAddress.getID()){
					defaultAddress.setIsDefault("NOR");
					receiveAddressMapper.updateByPrimaryKeySelective(defaultAddress);
				}
			}
		
			receiveAddressMapper.updateByPrimaryKeySelective(receiveAddress);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		LogUtil.logOutput("收货地址管理微服务","updateAddress",requestID,"无");
		
	}

	
	@Override
	public void deleteAddress(Integer id,String requestID) {
		
		LogUtil.logInput("收货地址管理微服务","deleteAddress",requestID,id);
		
		try{
			
			ReceiveAddress address = new ReceiveAddress();
			address.setID(id);
			address.setStatus("DEL");
			address.setIsDefault("NOR");
			address.setDelTime(new Date());
			receiveAddressMapper.updateByPrimaryKeySelective(address);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		LogUtil.logOutput("收货地址管理微服务", "deleteAddress", requestID, "无");
		
		
	}

	
	@Override
	public ReceiveAddress getAddress(Integer id,String requestID) {
		
		LogUtil.logInput("收货地址管理微服务", "getAddress", requestID, id);
		
		ReceiveAddress address = receiveAddressMapper.selectByPrimaryKey(id);
		
		LogUtil.logOutput("收货地址管理微服务", "getAddress", requestID, address);
		
		return address;
	}
	
	
	@Override
	public List<ReceiveAddress> listAddress(String mqID, String requestID){
		
		LogUtil.logInput("收货地址管理微服务", "listAddress", requestID, mqID);
		
		List<ReceiveAddress> adds = receiveAddressMapper.selectAll();
		
		LogUtil.logOutput("收货地址管理微服务", "listAddress", requestID, adds);
		
		return adds;
	}

	
	@Override
	public ReceiveAddress getDefaultAddress(String mqID, String requestID) {
		
		LogUtil.logInput("收货地址管理微服务", "getDefaultAddress", requestID, mqID);
		
		ReceiveAddress address = new ReceiveAddress();
		address.setIsDefault("DEF");
		address.setMqID(mqID);
		List<ReceiveAddress> defaultAddress = receiveAddressMapper.selectByCondition(address);

		address = null;
		
		if(defaultAddress.size()>0){
			address = defaultAddress.get(0);
		}
			
		LogUtil.logOutput("收货地址管理微服务", "getDefaultAddress", requestID, address);
		
		return address;
	}
	
	
	@Override
	public List<ReceiveAddress> listUsableAddress(String mqID, String requestID) {
		
		LogUtil.logInput("收货地址管理微服务", "listUsableAddress", requestID, mqID);
		
		ReceiveAddress address = new ReceiveAddress();
		address.setStatus("OK");
		
		List<ReceiveAddress> adds = receiveAddressMapper.selectByCondition(address);
		
		LogUtil.logOutput("收货地址管理微服务", "listUsableAddress", requestID, adds);
		
		return adds;
		
	}

	
	@Override
	public int setUserDefaultAddress(Integer id,String isDefault,String requestID){
	
		LogUtil.logInput("收货地址管理微服务", "setUserDefaultAddress", requestID, id, isDefault);
		
		try{
			
			ReceiveAddress address = new ReceiveAddress();
			address.setID(id);
			address.setIsDefault(isDefault);
			
			if(isDefault.equals("DEF")){
				/* 找出原来设置的默认收货地址 并设置为非默认 如果找出来的地址和当前要设置的是同一个地址则不做任何操作 */
				ReceiveAddress defaultAddress = this.getDefaultAddress("mqid",UUID.randomUUID().toString());
				if(defaultAddress!=null && defaultAddress.getID()!=id){
					defaultAddress.setIsDefault("NOR");
					receiveAddressMapper.updateByPrimaryKeySelective(defaultAddress);
				}
				
			}
			receiveAddressMapper.updateByPrimaryKeySelective(address);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		LogUtil.logOutput("收货地址管理微服务", "setUserDefaultAddress", requestID, id);
		
		return id;
	}


	@Override
	public String getFullAddress(ReceiveAddress receiveAddress, String requestID) {
		
		LogUtil.logInput("收货地址管理微服务", "getFullAddress", requestID, receiveAddress);
		
		Address province = null;
		Address city 	 = null;
		Address district = null;
		
		if(receiveAddress.getProvinceID()!=null){
			province = addressMapper.selectByPrimaryKey(Integer.valueOf(receiveAddress.getProvinceID()));
		}
		if(receiveAddress.getCityID()!=null){
			city = addressMapper.selectByPrimaryKey(Integer.valueOf(receiveAddress.getCityID()));
		}
		if(receiveAddress.getDistrictID()!=null){
			district = addressMapper.selectByPrimaryKey(Integer.valueOf(receiveAddress.getDistrictID()));
		}
		
		String fullAddress = "";
		if(province!=null){
			fullAddress+=province.getName();
		}
		if(city!=null){
			fullAddress+=city.getName();
		}
		if(district!=null){
			fullAddress+=district.getName();
		}
		fullAddress+=receiveAddress.getAddress()==null?"":receiveAddress.getAddress();
		
		LogUtil.logOutput("收货地址管理微服务", "getFullAddress", requestID, fullAddress);
		
		return fullAddress;
	}
	
	
}
