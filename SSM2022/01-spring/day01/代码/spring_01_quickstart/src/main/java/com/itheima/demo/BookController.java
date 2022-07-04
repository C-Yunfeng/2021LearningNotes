package com.itheima.demo;

import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookController {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        // BookService bookService = ctx.getBean("bookService",BookService.class);
        //需class唯一
        // BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }
}
