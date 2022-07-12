package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 3.创建SpringMvc的配置文件，加载controller的bean
@Configuration
@ComponentScan("com.itheima.controller")

public class SpringMvcConfig {
}
