package com.product.data.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;

@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    private Integer guid;

    private String cityId;

    private String cityName;

    private String provinceId;


}