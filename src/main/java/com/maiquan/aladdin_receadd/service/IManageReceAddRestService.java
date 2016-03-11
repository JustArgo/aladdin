package com.maiquan.aladdin_receadd.service;

import java.util.Map;

import com.maiquan.aladdin_receadd.domain.CommonParam;

public interface IManageReceAddRestService {

	/**
	 * 新增用户收货地址
	 * @param address
	 * @return
	 */
	Map<String,Object> addAddress(CommonParam param);
	
	/**
	 * 更新用户收货地址
	 * @param address
	 * @return
	 */
	Map<String,Object> updateAddress(CommonParam param);
	
	/**
	 * 删除用户收货地址
	 * @param id
	 * @return
	 */
	Map<String,Object> deleteAddress(CommonParam param);
	
	/**
	 * 根据id获得用户收货地址
	 * @param id
	 * @return
	 */
	Map<String,Object> getAddress(CommonParam param);
	
	/**
	 * 查找所有的用户收货地址
	 * @return
	 */
	Map<String,Object> listAddress(CommonParam param);
	
	/**
	 * 得到用户的默认收货地址
	 * @return
	 */
	Map<String,Object> getDefaultAddress(CommonParam param);
	
	/**
	 * 查找可用的用户收货地址
	 * @return
	 */
	Map<String,Object> listUsableAddress(CommonParam param);
	
	/**
	 * 设置用户默认收货地址
	 * @param id
	 * @param isDefault
	 * @return
	 */
	Map<String,Object> setUserDefaultAddress(CommonParam param);
	
}
