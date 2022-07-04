package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.User;
import org.omg.CosNaming.BindingIterator;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BookDaoImpl implements BookDao {
    // private static int cnt=0;
    // private String username;

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    // public BookDaoImpl() {
    //     System.out.println("BookDaoImpl创建...");
    //    cnt+=1;
    //    System.out.println(cnt);
    // }

    // public void init(){
    //     System.out.println("初始化方法......");
    // }
    // public void destroy(){
    //     System.out.println("销毁方法......");
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    public void save() {
        System.out.println("book dao save ...");
        // System.out.println(username);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
    }

}
