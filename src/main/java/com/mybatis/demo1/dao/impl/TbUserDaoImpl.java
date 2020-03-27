package com.mybatis.demo1.dao.impl;

import com.mybatis.demo1.dao.TbUserDao;
import com.mybatis.demo1.pojo.TbUser;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TbUserDaoImpl implements TbUserDao {

    public SqlSession sqlSession;
    public TbUserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }


    public List<TbUser> queryUserAll() {
        return sqlSession.selectList("TbUserDao.queryUserAll");
    }

    public TbUser findUserById(int id) {
        return sqlSession.selectOne("TbUserDao.findUserById",id);
    }

    public void insertUser(TbUser tbUser) {
        this.sqlSession.insert("TbUserDao.insertUser",tbUser);
    }

    public void updateUser(TbUser tbUser) {
        this.sqlSession.update("TbUserDao.updateUser",tbUser);
    }

    public void delUser(int id) {
        this.sqlSession.delete("TbUserDao.delUser",id);
    }
}
