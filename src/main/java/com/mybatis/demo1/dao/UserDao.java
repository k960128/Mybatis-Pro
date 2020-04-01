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

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据用户模糊查询
     */
    public List<User> findByUsername(@Param("username") String username);

    /*
    *   根据Sql片段查询
    * */
    public List<User> querySqlUser();

/*    1、一旦有条件成立的when，后续的when就不再执行
      2、当所有的when都不执行，才会执行otherwise*/

    public List<User> queryUserListByNameOrPass(@Param("username") String username,@Param("password") String password);


}
