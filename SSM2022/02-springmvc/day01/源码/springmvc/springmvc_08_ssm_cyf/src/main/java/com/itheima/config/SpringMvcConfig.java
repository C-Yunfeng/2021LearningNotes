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
到此完成了所有的框架整合，当WEB容器启动时，会加载两个配置类SpringConfig.class和SpringMvcConfig.class，
SpringConfig加载对应的Bean，SpringMvcConfig加载自己对应的Bean。
Spring的容器无法访问Mvc的容器，但SpringMvc容器可以访问Spring的容器（父子容器）
 */
public class SpringMvcConfig {
}
