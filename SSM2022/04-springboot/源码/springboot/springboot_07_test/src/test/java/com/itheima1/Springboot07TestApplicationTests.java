package com.itheima1;

import com.itheima.Springboot07TestApplication;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 2.测试类会默认加载引导类，所以自动初始化Spring环境配置。
// 默认只会加载同级的包，即必须在com.itheima下。此时可以使用指定加载类的方法
@SpringBootTest(classes = Springboot07TestApplication.class)
class Springboot07TestApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void save() {
        bookService.save();
    }

}
