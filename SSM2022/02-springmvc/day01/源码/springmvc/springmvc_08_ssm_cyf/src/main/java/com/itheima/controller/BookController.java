package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 25.控制器类
@RestController
// 26.模块的公共映射
@RequestMapping("/books")
public class BookController {
    // 27.调用业务层接口
    @Autowired
    private BookService bookService;

    // 28.修改所有请求method
    @PostMapping
    // 29.参数从JSON数据获取，配置@RequestBody，或者@PathVariable。到此，后台所有功能做完了
    public boolean save(@RequestBody Book book) {
        // 24.五个方法传参数
        return bookService.save(book);
    }
    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }
    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
}
