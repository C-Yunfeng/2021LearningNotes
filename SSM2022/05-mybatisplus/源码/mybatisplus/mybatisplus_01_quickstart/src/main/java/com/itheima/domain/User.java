package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

//lombok

// 不包含全参和无参构造
@Data
// @TableName
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}
