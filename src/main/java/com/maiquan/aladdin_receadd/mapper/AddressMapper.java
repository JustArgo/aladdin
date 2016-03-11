package com.maiquan.aladdin_receadd.mapper;

import java.util.List;

import com.maiquan.aladdin_receadd.domain.Address;

public interface AddressMapper {

	/**
	 * 获得所有的省
	 */
	List<Address> getAllProvince();
	
	/**
	 * 根据id选择对象
	 */
	Address selectByPrimaryKey(Integer id);
	
	/**
	 * 根据上层id 选择下层
	 */
	List<Address> selectByPid(Integer pid);
	
	
}
