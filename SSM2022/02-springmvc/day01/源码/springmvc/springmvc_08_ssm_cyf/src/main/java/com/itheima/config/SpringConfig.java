package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 1.定义Spring配置
@Configuration
@ComponentScan({"com.itheima.service"})
// 3.加上classpath，防止tomcat找不到。并导入Jdbc和MyBatis
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MyBatisConfig.class})
// 36.开启事务管理器配置
@EnableTransactionManagement
public class SpringConfig {
}
