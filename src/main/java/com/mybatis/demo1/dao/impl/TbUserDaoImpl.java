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
        return sqlSession.selectList("tbUserDao.queryUserAll");
    }

    public TbUser findUserById(int id) {
        return sqlSession.selectOne("tbUserDao.findUserById",id);
    }

    public void insertUser(TbUser tbUser) {
        this.sqlSession.insert("tbUserDao.insertUser",tbUser);
    }

    public void updateUser(TbUser tbUser) {
        this.sqlSession.update("tbUserDao.updateUser",tbUser);
    }

    public void delUser(int id) {
        this.sqlSession.delete("tbUserDao.delUser",id);
    }
}
