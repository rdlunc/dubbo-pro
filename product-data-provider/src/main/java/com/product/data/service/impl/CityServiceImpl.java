package com.product.data.service.impl;

import com.product.data.api.CityService;
import com.product.data.dao.CityMapper;
import com.product.data.pojo.City;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xusha on 2017/1/14.
 */
@Service(value = "cityService")
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Override
    public City getCityById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }
}
