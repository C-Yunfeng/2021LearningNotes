package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_bak.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);
        //按类型获取bean
        BookServiceImpl bookService = ctx.getBean(BookServiceImpl.class);
        System.out.println(bookService);
        // BookService bookService = ctx.getBean(BookService.class);
        // System.out.println(bookService);
    }
}
