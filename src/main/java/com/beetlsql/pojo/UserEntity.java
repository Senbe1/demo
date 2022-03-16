package com.beetlsql.pojo;

import lombok.Data;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Table;

/**
 *
 *@Author lzj
 *@desorption
 *@date 2022/2/25 13:55
 */
@Data
@Table(name="sys_user")
public class UserEntity {
    @AutoID
    private Integer id;
    private String name;
    private Integer departmentId;
}
