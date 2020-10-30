package org.Swordsman.Test;

import org.Swordsman.dao.IUserDao;
import org.Swordsman.domain.QueryVo;
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
import java.util.Date;
import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/16-9:45
 * @Description:
 */
public class mybatisTest {
    public InputStream in;
    public SqlSessionFactory factory;
    public SqlSession session;
    public IUserDao mapper;

    @Before//测试执行前执行
    public void init() throws IOException {
        /*
            加载配置文件
         */
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象  openSession 中有一个构造方法为 SqlSession openSession(boolean autoCommit); 设置是否自动提交事务
        session = factory.openSession();
        //4.使用SqlSession对象创建Dao接口代理对象
        mapper = session.getMapper(IUserDao.class);
    }

    @After//测试执行后执行
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        /*
            释放相关资源
         */
        session.close();
        in.close();
    }

    @Test// 测试查询所有用户
    public void testFindAll() {
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test//测试保存用户
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis saveService");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("烟台蓬莱县");
        System.out.println("保存之前:" + user);
        mapper.saveUser(user);
        System.out.println("保存之后:" + user);
    }

    @Test//测试修改用户
    public void testUpdate() {
        User user = new User();
        user.setId(49);
        user.setUsername("mybatis update service");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("烟台蓬莱县");
        mapper.updateUser(user);
    }

    @Test//测试删除用户
    public void testDelete() {
        mapper.deleteUser(49);
    }

    @Test//测试查询单个用户
    public void testFindOne() {
        User user = mapper.findById(48);
        System.out.println(user);
    }


    @Test//测试模糊查询用户
    public void testFindName() {
        List<User> users = mapper.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test//测试查询总记录数
    public void testFindTotal() {
        int count = mapper.findByTotal();
        System.out.println(count);
    }
    @Test//测试查询QueryVo条件用户
    public void testFindQueryVo() {
        QueryVo vo = new QueryVo();
        User user1 = new User();
        user1.setUsername("%王%");
        vo.setUser(user1);
        List<User> userByVo = mapper.findUserByVo(vo);
        for (User user : userByVo) {
            System.out.println(user);
        }
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
