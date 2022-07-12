package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 4.tomcat容器启动配置，在里面加载spring配置
public class ServeletContainerInitConfig extends AbstractDispatcherServletInitializer {
    // 加载springMVC容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }
    // 设置哪些请求归属SpringMVC处理
    @Override
    protected String[] getServletMappings() {
        // 所有请求归SpringMVC处理
        return new String[]{"/"};
    }
    // 加载spring容器配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
