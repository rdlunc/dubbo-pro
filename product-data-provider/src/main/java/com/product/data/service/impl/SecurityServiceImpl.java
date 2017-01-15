package com.product.data.service.impl;

import javax.annotation.Resource;


import com.product.data.api.SecurityService;
import com.product.data.dao.SecurityMapper;
import com.product.data.pojo.Security;
import org.springframework.stereotype.Service;

@Service(value = "securityService")
public class SecurityServiceImpl implements SecurityService {

	@Resource
	private SecurityMapper securityMapper;

	@Override
	public Security getSecurityByKey(String key) {
		// TODO Auto-generated method stub
		Security security = securityMapper.selectByPrimaryKey(key);
		String fSecuritykey = security.getFSecuritykey();
		return security;
	}
}
