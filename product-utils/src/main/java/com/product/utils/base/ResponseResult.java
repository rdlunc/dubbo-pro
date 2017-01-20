package com.product.utils.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.product.utils.enums.ResponseErrorEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by major on 2017/1/20.
 * 统一请求返回结果model
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class ResponseResult<T> {
    @Getter
    @Setter
    private boolean success;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T data;

    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 */
    @Getter
    private String errorCode;

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<T>();
    }

    /**
     * 设置错误信息
     */
    public void setErrorInfo(ResponseErrorEnum responseErrorEnum) {
        this.errorCode = responseErrorEnum.getCode();
        this.message = responseErrorEnum.getMessage();
    }
}
