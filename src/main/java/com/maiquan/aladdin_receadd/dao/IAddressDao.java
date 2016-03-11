package com.maiquan.aladdin_receadd.dao;

import java.util.List;

import com.maiquan.aladdin_receadd.domain.Address;

public interface IAddressDao {
	
	public Address getAddress(Integer id);
	public List<Address> getSubAddress(Integer pid);
	
	public void addAddress(Address address);
	public void addSubAddress(List<Address> addresses);
	
}
