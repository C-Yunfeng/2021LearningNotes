package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${course}")
    private String course;

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println(course);
        System.out.println(environment.getProperty("users.name"));
        return "hello spring boot";
    }
}
