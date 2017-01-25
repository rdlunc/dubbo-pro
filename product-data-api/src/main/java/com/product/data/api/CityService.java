package com.product.data.api;

import com.product.data.pojo.City;

/**
 * Created by xusha on 2017/1/14.
 */
public interface CityService {
    int deleteByPrimaryKey(Integer guid);
    int insert(City record);
    int insertSelective(City record);
    City selectByPrimaryKey(Integer guid);
    int updateByPrimaryKeySelective(City record);
    int updateByPrimaryKey(City record);

}
