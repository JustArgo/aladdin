package com.maiquan.aladdin_receadd;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maiquan.aladdin_receadd.domain.ReceiveAddress;
import com.maiquan.aladdin_receadd.service.IManageReceAddService;

public class TestReceiveAddress {

	private IManageReceAddService manageReceAddService;
	
	@Before
	public void setUp(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();
		manageReceAddService = (IManageReceAddService) context.getBean("manageReceAddService");
	}
	
	/**
	 * 测试新增用户收货地址
	 * @throws Exception
	 */
	
	public void testSaveUserAddressInfo() throws Exception{

		ReceiveAddress address = new ReceiveAddress();
		address.setID(33);
		address.setMqID("3535");
		address.setCountryID(1);
		address.setProvinceID(88);
		address.setCityID(8810);
		address.setDistrictID(881010);
		address.setAddress("翔安街道");
		address.setIsDefault("NOR");
		address.setRecName("樱木花道");
		address.setStatus("OK");
		
		manageReceAddService.addAddress(address,UUID.randomUUID().toString());
		ReceiveAddress add = manageReceAddService.getAddress(33,UUID.randomUUID().toString());
		Assert.assertNotNull(add);
		
	}
	
	/**
	 * 测试删除用户收货地址
	 * @throws Exception
	 */
	
	public void testDelUserAddress() throws Exception{
		
		manageReceAddService.deleteAddress(33,UUID.randomUUID().toString());
		ReceiveAddress add = manageReceAddService.getAddress(33,UUID.randomUUID().toString());
		Assert.assertEquals("DEL", add.getStatus());
			
	}
	
	/**
	 * 测试修改用户收货地址
	 */
	public void testUpdateUserAddressInfo() {

		ReceiveAddress address = new ReceiveAddress();
		address.setID(657870674);
		address.setRecMobile("15156767");
		manageReceAddService.updateAddress(address,UUID.randomUUID().toString());
		
		ReceiveAddress add = manageReceAddService.getAddress(657870674,UUID.randomUUID().toString());
		Assert.assertEquals("15156767", add.getRecMobile());
		
	}
	
	/**
	 * 测试查询某个用户收货地址
	 */
	
	public void testGetUesrAddressInfo() throws Exception{
		
		ReceiveAddress address = manageReceAddService.getAddress(33,UUID.randomUUID().toString());
		Assert.assertNotNull(address);
		
	}

	/**
	 * 测试查询所有可用的用户收货地址
	 */
	
	public void testQueryAllUserAddressList(){
		
		List<ReceiveAddress> addresses = manageReceAddService.listAddress("2",UUID.randomUUID().toString());
		Assert.assertEquals(9, addresses.size());
		
	}
	
	/**
	 * 测试查询所有可用的用户收货地址
	 */
	public void testQueryUserAddressList(){
		
		List<ReceiveAddress> addresses = manageReceAddService.listUsableAddress("2",UUID.randomUUID().toString());
		Assert.assertEquals(1, addresses.size());
		
	}
	
	/**
	 * 测试设置用户默认收货地址
	 */
	public void testSetUserDefaultAddress(){
		
		manageReceAddService.setUserDefaultAddress(33, "DEF",UUID.randomUUID().toString());
		ReceiveAddress address = manageReceAddService.getAddress(33,UUID.randomUUID().toString());
		String isDefault = address.getIsDefault();
		Assert.assertEquals("DEF", isDefault);
	}
	
	/**
	 * 测试根据收货地址 获得 完整地址字符串
	 */
	@Test
	public void testGetFullAddress(){
		
		ReceiveAddress receiveAddress = new ReceiveAddress();
		receiveAddress.setCountryID(8);
		receiveAddress.setProvinceID(10);
		receiveAddress.setCityID(1010);
		receiveAddress.setAddress("老胡同");
		String fullAddress = manageReceAddService.getFullAddress(receiveAddress, UUID.randomUUID().toString());
		System.out.println(fullAddress);
		
	}
	
}
