package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 22.写实现类
public class BookServiceImpl implements BookService {
    // 23.用Dao的接口，所以需要注入
    @Autowired
    private BookDao bookDao;
    // 如果Spring里没有配置bookDao的Bean，则会检查。解决办法右键

    public boolean save(Book book) {
        // 24.五个方法传参数
        bookDao.save(book);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
