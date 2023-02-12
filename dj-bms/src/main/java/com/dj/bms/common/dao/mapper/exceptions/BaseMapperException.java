package com.dj.bms.common.dao.mapper.exceptions;

/**
 * @Author: zcq
 * @Date: 2019/10/7 18:15
 */
public class BaseMapperException extends RuntimeException{

    public BaseMapperException(String message) {
        super(message);
    }

    public BaseMapperException(Throwable throwable) {
        super(throwable);
    }

    public BaseMapperException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
