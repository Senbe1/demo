package com.beetlsql;

import com.beetlsql.pojo.UserEntity;
import com.google.gson.Gson;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.H2Style;
import org.beetl.sql.ext.DBInitHelper;
import org.beetl.sql.ext.DebugInterceptor;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *@Author lzj
 *@desorption
 *@date 2022/2/25 13:21
 */
@Slf4j
public class QuickTest {
    private static DataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        //内存数据库
        hikariDataSource.setJdbcUrl("jdbc:h2:mem:dbtest;DB_CLOSE_ON_EXIT=FALSE");
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");
        hikariDataSource.setDriverClassName("org.h2.Driver");
        return hikariDataSource;
    }

    private  static SQLManager getSQLManager(){
        //得到一个数据源
        DataSource dataSource = dataSource();
        //得到一个ConnectSource，单数据源
        ConnectionSource source = ConnectionSourceHelper.getSingle(dataSource);
        //SQLManagerBuilder唯一的参数就是ConnectionSource
        SQLManagerBuilder sqlManagerBuilder = new SQLManagerBuilder(source);
        //命名转化，数据库表和列名是下划线风格，转化成java对应的首字母大写（驼峰）
        sqlManagerBuilder.setNc(new UnderlinedNameConversion());
        //拦截器，非必须，此处设置的是debug拦截器，可以详细的查看执行后的sql语句与sql参数
        sqlManagerBuilder.setInters(new Interceptor[]{new DebugInterceptor()});
        //数据库风格，由于此次使用的是h2数据库，所以使用h2style
        sqlManagerBuilder.setDbStyle(new H2Style());
        SQLManager sqlManager = sqlManagerBuilder.build();
        return sqlManager;
    }

    public static void main(String[] args) throws Exception{
        SQLManager sqlManager = getSQLManager();
        //初始化数据脚本
        DBInitHelper.executeSqlScript(sqlManager,"db/schema.sql");
        //得到数据库中所有表
        Set<String> all = sqlManager.getMetaDataManager().allTable();
        log.info("数据库的所有表名为：{}",all);

        /*按照主键查询*/
        UserEntity user1 = sqlManager.unique(UserEntity.class,1);
        user1.setName("zhangsan");
        sqlManager.updateById(user1);

        /*按照模板查询*/
        UserEntity user2 = new UserEntity();
        user2.setDepartmentId(1);
        List<UserEntity> list = sqlManager.template(user2);
        log.info("模板查询测试例2结果：{}",new  Gson().toJson(list));

        /*自定义SQL*/
        String sql = "select * from sys_user where id = ?";
        Integer id = 1;
        SQLReady sqlReady = new SQLReady(sql,new Object[]{id});
        List<UserEntity> userEntities = sqlManager.execute(sqlReady,UserEntity.class);
        log.info("自定义sql测试例结果:{}",userEntities);

        String updateSql = "update sys_user set name =? where id =?";
        String name ="lijz";
        SQLReady sqlReady1 = new SQLReady(updateSql,new Object[]{name,id});
        sqlManager.executeUpdate(sqlReady1);

        /*模板Sql*/
        String sql00 = "select * from sys_user where department_id=#{departmentId} and name=#{name}";
        UserEntity paras00 = new UserEntity();
        paras00.setName("lijz");
        paras00.setDepartmentId(1);
        List<UserEntity> list00 = sqlManager.execute(sql00,UserEntity.class,paras00);
        log.info("模板sql测试例1结果:{}",list00);

        String sql01 = "select * from sys_user where department_id=#{myDeptId} and name=#{myName}";
        Map paras01 = new HashMap();
        paras01.put("myDeptId",1);
        paras01.put("myName","lijz");
        List<UserEntity> list01 = sqlManager.execute(sql01,UserEntity.class,paras01);
        log.info("模板sql测试例2结果：{}",new  Gson().toJson(list01));



    }

}
