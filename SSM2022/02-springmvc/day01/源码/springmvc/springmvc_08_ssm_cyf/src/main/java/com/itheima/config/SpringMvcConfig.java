package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 14.核心配置类要有Configuration和ComponentScan
@Configuration
@ComponentScan("com.itheima.controller")
// 15.配置EnableMvc。
@EnableWebMvc
/*
到此，完成了所有的框架整合
 */
public class SpringMvcConfig {
}
