package com.maiquan.aladdin_receadd.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import com.maiquan.aladdin_receadd.domain.Address;

public class ObjectToJSONSerializer<T> implements RedisSerializer<T>{

	@Override
	public byte[] serialize(T t) throws SerializationException {
		byte[] ret = null;
		try {
			ret = JSON.json(t).getBytes("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		String str = "";
		try {
			str = new String(bytes,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			return (T) JSON.parse(str,Address.class);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
