package com.product.web;

import com.product.data.api.CityService;
import com.product.data.pojo.City;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/1/17.
 * 城市接口
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {
    private Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取城市信息接口")
    @ApiImplicitParam(name = "city", value = "城市对象", required = true, dataType = "City")
    @RequestMapping(value = "/getCity", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<City> getCity(HttpServletRequest request, HttpServletResponse response , City city){
        logger.info("getCity start");
        return new ResponseEntity<City>(cityService.getCityById(city.getGuid()), HttpStatus.OK);
    }
}
