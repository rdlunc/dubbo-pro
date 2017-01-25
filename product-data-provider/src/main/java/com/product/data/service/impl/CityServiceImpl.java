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
    public int deleteByPrimaryKey(Integer guid) {
        return cityMapper.deleteByPrimaryKey(guid);
    }

    @Override
    public int insert(City record) {
        return cityMapper.insert(record);
    }

    @Override
    public int insertSelective(City record) {
        return cityMapper.insertSelective(record);
    }

    @Override
    public City selectByPrimaryKey(Integer guid) {
        return cityMapper.selectByPrimaryKey(guid);
    }

    @Override
    public int updateByPrimaryKeySelective(City record) {
        return cityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(City record) {
        return cityMapper.updateByPrimaryKey(record);
    }
}
