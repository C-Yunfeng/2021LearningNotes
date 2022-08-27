package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
// 1.继承BaseMapper，泛型用实体类名
public interface UserDao extends BaseMapper<User> {
}
