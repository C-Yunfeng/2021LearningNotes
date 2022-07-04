package com.itheima.factory;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;

public class StaticFactory {
    public static BookDao getBookDao(){
        // System.out.println("FactoryStaticMethod...");
        return new BookDaoImpl();
    }
}
