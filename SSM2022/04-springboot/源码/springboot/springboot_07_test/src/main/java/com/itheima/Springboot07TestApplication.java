package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1.引导类会把所在的包及所有子包扫描，所以ServiceImpl里的@Service有效，
// 并将其识别为bean
@SpringBootApplication
public class Springboot07TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07TestApplication.class, args);
    }

}
