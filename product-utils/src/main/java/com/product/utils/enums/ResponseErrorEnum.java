package com.product.utils.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by major on 2017/1/20.
 */
@Getter
@AllArgsConstructor
public enum ResponseErrorEnum {
    ILLEGAL_PARAMS("ILLEGAL_PARAMS", "请求参数不合法!"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "接口内部异常!");

    // 序列化enum
    @JsonValue
    private Map<String, Object> serialize() {
        Map<String, Object> valueMap = new HashMap<String,Object>(2);
        valueMap.put("code", this.code);
        valueMap.put("message", this.message);
        return valueMap;
    }

    private String code;

    private String message;

}
