package com.product.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.product.data.domain.ParkingBasicDataSyncResponse;
import com.product.service.InfrastructDeal;
import com.product.utils.util.JsonUtil;
import com.product.utils.util.ReturnCode;

@Component
public class ParkingBasicDataSync implements InfrastructDeal {
	@Override
	public String accept(HttpServletRequest request) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ParkingBasicDataSyncResponse parkingBasicDataSyncResponse = new ParkingBasicDataSyncResponse();
		parkingBasicDataSyncResponse.setCode(ReturnCode.SUCCESS.ordinal());
		parkingBasicDataSyncResponse.setMessage(ReturnCode.SUCCESS.toString());
		parkingBasicDataSyncResponse.setPark_id("012e5ef643804cfa9e364fe6a5f90668");
		parkingBasicDataSyncResponse.setSuccessful(true);
		return JsonUtil.convertObject2String(parkingBasicDataSyncResponse);
	}
}
