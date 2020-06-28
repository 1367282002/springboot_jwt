package com.jwt.config;

import com.jwt.bean.ResultBO;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 同意一次处理类
 */
@RestControllerAdvice
@Slf4j
public class PermissionHandler {
    @ExceptionHandler(value = { SignatureException.class })
    @ResponseBody
    public ResultBO<?> authorizationException(SignatureException e){
        log.debug("错误了",e.getMessage());
        return new ResultBO(123,e.getMessage());
    }
}