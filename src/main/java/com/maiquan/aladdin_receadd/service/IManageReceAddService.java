package com.maiquan.aladdin_receadd.service;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.common.json.JSONObject;
import com.maiquan.aladdin_receadd.domain.Address;
import com.maiquan.aladdin_receadd.domain.CommonParam;
import com.maiquan.aladdin_receadd.domain.ReceiveAddress;

/**
 * 用来管理收货地址的微服务
 * @author 黄永宗
 * @date 2016年2月18日 上午10:54:43
 */
public interface IManageReceAddService {
	
	/**
	 * 新增用户收货地址
	 * @param address
	 * @return
	 */
	int addAddress(ReceiveAddress address,String requestID);
	
	/**
	 * 更新用户收货地址
	 * @param address
	 * @return
	 */
	void updateAddress(ReceiveAddress address,String requestID);
	
	/**
	 * 删除用户收货地址
	 * @param id
	 * @return
	 */
	void deleteAddress(Integer id,String requestID);
	
	/**
	 * 根据id获得用户收货地址
	 * @param id
	 * @return
	 */
	ReceiveAddress getAddress(Integer id,String requestID);
	
	/**
	 * 查找某个用户的所有收货地址
	 * @return
	 */
	List<ReceiveAddress> listAddress(String mqID, String requestID);
	
	/**
	 * 得到用户的默认收货地址
	 * @return
	 */
	ReceiveAddress getDefaultAddress(String mqID, String requestID);
	
	/**
	 * 查找可用的用户收货地址
	 * @return
	 */
	List<ReceiveAddress> listUsableAddress(String mqID, String requestID);
	
	/**
	 * 设置用户默认收货地址
	 * @param id
	 * @param isDefault
	 * @return
	 */
	int setUserDefaultAddress(Integer id,String isDefault,String requestID);
	
	/**
	 * 给定一个收货地址  返回完整的地址字符串
	 * @param receiveAddress
	 * @return
	 */
	String getFullAddress(ReceiveAddress receiveAddress, String requestID);
}
