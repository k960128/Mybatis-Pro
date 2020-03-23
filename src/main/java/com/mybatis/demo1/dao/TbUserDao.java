package com.mybatis.demo1.dao;

import com.mybatis.demo1.pojo.TbUser;

import java.util.List;

public interface TbUserDao {

    /**
     * 查询全部
     */
    public List<TbUser> queryUserAll();

    /**
     * 根据ID查询
     */
    public TbUser findUserById(int id);

    /**
     * 新增用户
     */
    public void insertUser(TbUser tbUser);

    /**
     * 修改用户
     * @param tbUser
     */
    public void updateUser(TbUser tbUser);

    /**
     * 删除用户
     * @param id
     */
    public void delUser(int id);

}
