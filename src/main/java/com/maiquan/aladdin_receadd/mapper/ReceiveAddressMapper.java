package com.maiquan.aladdin_receadd.mapper;

import java.util.List;

import com.maiquan.aladdin_receadd.domain.ReceiveAddress;

public interface ReceiveAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveAddress record);

    int insertSelective(ReceiveAddress record);

    ReceiveAddress selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ReceiveAddress record);

    int updateByPrimaryKey(ReceiveAddress record);
    
    List<ReceiveAddress> selectAll();
    
    List<ReceiveAddress> selectByCondition(ReceiveAddress address);

}