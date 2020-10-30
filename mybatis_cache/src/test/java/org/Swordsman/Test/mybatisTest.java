package org.Swordsman.Test;

import org.Swordsman.dao.IUserDao;
import org.Swordsman.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/16-9:45
 * @Description:
 */
public class mybatisTest {
    public InputStream in;
    public SqlSessionFactory factory;

    @Before//测试执行前执行
    public void init() throws IOException {
        /*
            加载配置文件
         */
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象  openSession 中有一个构造方法为 SqlSession openSession(boolean autoCommit); 设置是否自动提交事务

    }

    @After//测试执行后执行
    public void destroy() throws IOException {
        in.close();
    }

    @Test//测试一级缓存
    public void testFirstLevelCache() {
        SqlSession session1 = factory.openSession();
        //4.使用SqlSession对象创建Dao接口代理对象
        IUserDao mapper1 = session1.getMapper(IUserDao.class);
        User user1 = mapper1.findById(41);
        System.out.println(user1);
        session1.close();//清空一级缓存

        SqlSession session2 = factory.openSession();
        //4.使用SqlSession对象创建Dao接口代理对象
        IUserDao mapper2 = session2.getMapper(IUserDao.class);
        User user2 = mapper2.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }


}
/***
 //1.读取配置文件
 try {
 InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
 //2.创建SqlSessionFactory工厂
 SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
 SqlSessionFactory factory = builder.build(in);
 //3.使用工厂生产SqlSession对象
 SqlSession session = factory.openSession();
 //4.使用SqlSession对象创建Dao接口代理对象
 IUserDao mapper = session.getMapper(IUserDao.class);
 //5.执行dao中的方法
 List<User> list = mapper.findAll();
 for (User user : list) {
 System.out.println(user);
 }
 //6.释放资源
 session.close();
 } catch (Exception e) {
 e.printStackTrace();
 }
 */
