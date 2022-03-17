package com.example.demo.springbootdemo.domain.entity;


import lombok.Data;
import org.beetl.sql.annotation.entity.AutoID;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    @AutoID
    private Long id;
}
