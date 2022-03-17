package com.example.demo.springbootdemo.domain.entity;

import lombok.Data;
import org.beetl.sql.annotation.entity.Table;

@Data
@Table(name = "user")
public class UserEntity extends BaseEntity {
    /**
     * 名
     */
    private String firstName;

    /**
     * 姓
     */
    private String lastName;

    /**
     * 年龄
     */
    private Integer age;

}
