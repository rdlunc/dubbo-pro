package com.product.data.api;

import com.product.data.pojo.District;

/**
 * Created by xusha on 2017/1/26.
 */
public interface DistrictService {
    int deleteByPrimaryKey(Integer guid);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer guid);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}
