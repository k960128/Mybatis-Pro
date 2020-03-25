package com.mybatis.demo1.main;

import com.mybatis.demo1.dao.TbUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;

public class MybatisTest {

    InputStream inputStream = null;
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;

    @Before
    public void init() throws IOException {
        //读取配置文件
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //生产session对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void findAllTest(){
        TbUserDao tbUserDao = sqlSession.getMapper(TbUserDao.class);
        System.out.println(tbUserDao.queryUserAll());
    }
}
