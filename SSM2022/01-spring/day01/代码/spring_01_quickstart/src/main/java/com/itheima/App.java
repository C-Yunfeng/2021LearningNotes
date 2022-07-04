package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //get IOC
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get bean by id
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        //get bean by class
        BookServiceImpl bookServiceimpl = ctx.getBean(BookServiceImpl.class);
        bookServiceimpl.save();



    }
}
