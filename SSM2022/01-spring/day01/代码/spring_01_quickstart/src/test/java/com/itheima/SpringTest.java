package com.itheima;

import com.itheima.dao.BookDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    //测试scope属性
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        System.out.println(ctx);
        //get bean by id
//        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
//        ((ClassPathXmlApplicationContext)ctx).close();
//        System.out.println(bookDao1);
        System.out.println(bookDao2);
    }
}
