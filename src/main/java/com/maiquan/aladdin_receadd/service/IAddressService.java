package com.maiquan.aladdin_receadd.service;

import java.util.List;

import com.maiquan.aladdin_receadd.domain.Address;

public interface IAddressService {

	void addAddress(Address address, String requestID);
	Address getAddress(Integer id, String requestID);
	void addSubAddress(List<Address> addresses, String requestID);
	List<Address> getSubAddress(Integer pid, String requestID);
}
