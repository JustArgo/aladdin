package com.maiquan.aladdin_receadd.service.impl;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.maiquan.aladdin_receadd.domain.CommonParam;
import com.maiquan.aladdin_receadd.service.IManageReceAddRestService;

@Path("/receiveAddress")
public class ManageReceAddRestServiceImpl implements IManageReceAddRestService{

	@Path("/receiveAddress")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> addAddress(CommonParam param) {
		return null;
	}

	@Path("/receiveAddress")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> deleteAddress(CommonParam param) {
		return null;
	}
	
	@Path("/receiveAddress")
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> updateAddress(CommonParam param) {
		return null;
	}

	
	@Path("/receiveAddress")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> getAddress(CommonParam param) {
		return null;
	}

	@Path("/receiveAddressList")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> listAddress(CommonParam param) {
		return null;
	}

	@Path("/defaultAddress")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> getDefaultAddress(CommonParam param) {
		
		return null;
	}

	@Path("/usableAddress")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> listUsableAddress(CommonParam param) {
		
		return null;
	}

	@Path("/defaultAddress")
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public Map<String, Object> setUserDefaultAddress(CommonParam param) {
		return null;
	}

}
