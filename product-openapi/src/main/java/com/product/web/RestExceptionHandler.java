package com.product.web;

import com.product.utils.base.ResponseResult;
import com.product.utils.base.RestResultGenerator;
import com.product.utils.enums.ResponseErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.UnexpectedTypeException;

/**
 * Created by major on 2017/1/25.
 * 统一异常处理
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 统一的rest接口异常处理器
     *
     * @param e 捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private <T> ResponseResult<T> globalExceptionHandler(Exception e) {

        LOGGER.error("--------->接口调用异常!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> ResponseResult<T> illegalParamsExceptionHandler(UnexpectedTypeException e) {

        LOGGER.error("--------->请求参数不合法!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.ILLEGAL_PARAMS);
    }
}
