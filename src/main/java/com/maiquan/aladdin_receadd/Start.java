package com.maiquan.aladdin_receadd;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Start {

	public static void main(String[] args) throws Exception{

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();
		System.out.println("收货地址微服务");
		while(true){
			Thread.sleep(1000);
		}
		
	}
	
	/*
	 * IAddressService service = (IAddressService) context.getBean("addressService");
		Address address = new Address();
		address.setId(100);
		address.setName("潮阳");
		address.setLevel(100);
		address.setPid(500);
		service.addAddress(address);
		Address add = service.getAddress(100);
		if(add!=null){
			System.out.println(add.getId()+add.getName()+add.getLevel()+add.getPid());
		}
	 */
}
