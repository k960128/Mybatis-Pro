package com.mybatis.demo1.main;

import com.mybatis.demo1.dao.TbUserDao;
import com.mybatis.demo1.dao.UserDao;
import com.mybatis.demo1.dao.impl.TbUserDaoImpl;
import com.mybatis.demo1.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserDao {

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

    /*
     * 测试 #{} ${}
     * 通常在方法的参数列表上加上一个注释@Param("XXX") 显示指定参数的名字，然后通过${} #{}
     * Sql语句动态生成的时候，使用${}
     * Sql语句中某个参数进行站位的时候使用#{}
     * */
    @Test
    public void querUser(){
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //userDao.queryUser("User");
        userDao.queryUser1("User");
    }

    /*
     * 添加用户数据
     * */
    @Test
    public void insertUser(){
        User user = null;
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        for (int i =1;i<=100;i++)
        {
            user = new User();
            user.setUsername("manager-"+i);
            user.setPassword("manager--"+i);
            userDao.insertUser(user);
        }
        System.out.println("添加完成");
    }



    /*根据用户名模糊查询*/
    @Test
    public void findByUsername(){
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findByUsername("admin");
        for (User user: userList
             ) {
            System.out.println(user.toString());
        }
    }

}
