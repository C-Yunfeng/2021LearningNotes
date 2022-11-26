package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 30.Spring整合JUint的测试
@RunWith(SpringJUnit4ClassRunner.class)
// 31.制定配置类
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    // 33.因为方法里需要调用service的接口，没有，所以自动装配
    @Autowired
    private BookService bookService;

    // 32.写测试方法
    @Test
    public void testGetById(){
        Book book = bookService.getById(1);
        // 34.正式的测试需要断言匹配，这里只简单打印
        System.out.println(book);
        System.out.println("next debug...");
        System.out.println(book.getId());
    }

    // 35.继续其他接口的测试
    public void testGetAll(){
        List<Book> lst = bookService.getAll();
        System.out.println(lst);
    }
}
