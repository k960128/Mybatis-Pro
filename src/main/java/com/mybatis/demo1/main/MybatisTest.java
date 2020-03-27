package com.mybatis.demo1.main;

import com.mybatis.demo1.dao.TbUserDao;
import com.mybatis.demo1.dao.UserDao;
import com.mybatis.demo1.dao.impl.TbUserDaoImpl;
import com.mybatis.demo1.pojo.TbUser;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {

    InputStream inputStream = null;
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    TbUserDao tbUserDao = null;
    @Before
    public void init() throws IOException {
        //读取配置文件
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //生产session对象
        sqlSession = sqlSessionFactory.openSession();

        this.tbUserDao = new TbUserDaoImpl(sqlSession);

    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 查询全部
     */
    @Test
    public void findAllTest(){
        List<TbUser> tbUserList = this.tbUserDao.queryUserAll();
        for (TbUser tbUser: tbUserList
             ) {
            System.out.println(tbUser.toString());
        }
    }

    /**
     * 根据ID查询
     */
    @Test
    public void findById(){
        TbUser tbUser = null;
        tbUser = this.tbUserDao.findUserById(1);
        System.out.println(tbUser.toString());
    }

    /**
     * 添加用户
     */
    @Test
    public void insertTbUser(){
        TbUser tbUser = new TbUser();
        tbUser.setAge(16);
        tbUser.setBirthday(new Date("2020/09/12"));
        tbUser.setName("王小二");
        tbUser.setPassword("123456");
        tbUser.setSex(1);
        tbUser.setUser_name("evan");
        this.tbUserDao.insertUser(tbUser);
        System.out.println("添加成功！");
        System.out.println(tbUser.toString());
    }

    /**
     * 修改
     */
    @Test
    public void updateUser(){
        TbUser tbUser = new TbUser();
        tbUser.setAge(16);
        tbUser.setBirthday(new Date("2020/09/12"));
        tbUser.setName("王小二");
        tbUser.setPassword("123456");
        tbUser.setSex(1);


        //添加ID
        tbUser.setId(1);
        this.tbUserDao.updateUser(tbUser);
        System.out.println("修改完毕！");
        System.out.println(tbUser.toString());
    }

    /**
     * 删除用户
     */
    @Test
    public void delUser(){
        System.out.println("开始删除....");
        this.tbUserDao.delUser(2);
        System.out.println("删除成功.......");
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
        //userDao.queryUser1("User");
    }
}
