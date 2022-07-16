package com.itheima.exception;

public class BusinessException extends RuntimeException{
    // 5.完全复制粘贴
    private Integer code;

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
