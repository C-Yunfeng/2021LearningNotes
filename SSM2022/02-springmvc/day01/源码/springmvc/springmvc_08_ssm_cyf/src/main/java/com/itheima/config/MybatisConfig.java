package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    // 7.一般方法名叫sqlSessionFactory就可以，不用写sqlSessionFactoryBean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 8.添加两个配置。dataSource从参数来，参数是从Spring容器中根据类型自动装配的
        factoryBean.setDataSource(dataSource);
        // 9.类型别名扫描包
        factoryBean.setTypeAliasesPackage("com.itheima.domain");
        return factoryBean;
    }

    // 10.扫描映射(Dao)
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 11.制定映射从dao包加载，因为用接口开发，所以扫到接口即可。
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }

}
