package com.itheima.controller;

import com.itheima.exception.BusinessException_bak;
import com.itheima.exception.SystemException_bak;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//1.@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //3.@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(BusinessException_bak.class)
    //2.异常处理,形参传异常对象
    public Result doBusinessException(BusinessException_bak ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    @ExceptionHandler(SystemException_bak.class)
    public Result doSystemException(SystemException_bak ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}
