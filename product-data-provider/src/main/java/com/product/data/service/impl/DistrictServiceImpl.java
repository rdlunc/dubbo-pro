package com.product.data.service.impl;

import com.product.data.api.DistrictService;
import com.product.data.dao.DistrictMapper;
import com.product.data.pojo.District;

import javax.annotation.Resource;

/**
 * Created by xusha on 2017/1/26.
 */
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public int deleteByPrimaryKey(Integer guid) {
        return districtMapper.deleteByPrimaryKey(guid);
    }

    @Override
    public int insert(District record) {
        return districtMapper.insert(record);
    }

    @Override
    public int insertSelective(District record) {
        return districtMapper.insertSelective(record);
    }

    @Override
    public District selectByPrimaryKey(Integer guid) {
        return districtMapper.selectByPrimaryKey(guid);
    }

    @Override
    public int updateByPrimaryKeySelective(District record) {
        return districtMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(District record) {
        return districtMapper.updateByPrimaryKey(record);
    }
}
