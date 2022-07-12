package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

// 18.提供增删改查的功能
public interface BookDao {
    // 19.MyBatis自动代理创建实现，不想写实现，所以写注解。有两种方式
    // @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    public void save(Book book);
    @Update("update tbl_book set type=#{type}，name=#{name},description=#{description} where id=#{id}")
    public void update(Book book);
    @Delete("delete from tbl_book where id=#{id}")
    public void delete(Integer id);
    @Select("select * from tbl_book where id=#{id}")
    public Book getById(Integer id);
    @Select("select * from tbl_book")
    public List<Book> getAll();


}
