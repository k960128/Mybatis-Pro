package com.mybatis.demo1.dao;

import com.mybatis.demo1.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 查询全部 #{}
     */
    public List<User> queryUser(@Param("tableName") String tableName);

    /*
    * 查询全部 ${}
    * */
    public List<User> queryUser1(@Param("tableName")String tableName);

}
