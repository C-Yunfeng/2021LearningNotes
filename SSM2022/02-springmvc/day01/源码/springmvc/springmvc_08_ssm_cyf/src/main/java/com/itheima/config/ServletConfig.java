package com.itheima.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 12.继承AbDisSer（直接制定配置类），右键实现三个方法，见方法注释
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 加载spring的核心配置SpringConfig
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    // 加载SpringMvc配置（其实可以把SpringConfig和SpringMvcConfig整合起来）
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    // 让mvc拦截tomcat表现层，交给mvc处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 13.表单中文过滤器，有需求可以加上。
}
