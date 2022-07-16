package com.itheima.exception;
// 1.继承异常，不用手动在每个方法里抛
public class SystemException extends RuntimeException{
    // 2.添加异常编号
    private Integer code;
    // 3.生成构造方法，一般以下两种即可
    public SystemException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    // 4.生成get，set方法
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
