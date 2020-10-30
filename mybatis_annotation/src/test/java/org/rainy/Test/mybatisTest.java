package org.rainy.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rainy.dao.IUserDao;
import org.rainy.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/23-14:40
 * @Description:
 */
public class mybatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao mapper;

    @Before//测试前执行
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(IUserDao.class);
    }

    @After//测试后执行
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test//测试注解查询所有用户
    public void testFindAll() {
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test//测试注解保存用户
    public void testSaveUser() {
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setSex("男");
        user.setAddress("北京昌平区");
        mapper.saveUser(user);
    }

    @Test//测试注解更新用户
    public void testUpdateUser() {
        User user = new User();
        user.setId(49);
        user.setUsername("mybatis annotation update");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("合肥瑶海区");

        mapper.updateUser(user);
    }

    @Test//测试注解删除用户
    public void testDeleteUser(){
        mapper.deleteUser(49);
    }

    @Test//测试注解根据id查询用户
    public void testFindById(){
        User user = mapper.findById(48);
        System.out.println(user);
    }

    @Test//测试注解模糊查询
    public void testFindByUsername(){
        User user = new User();
        user.setUsername("%王%");
        List<User> users = mapper.findByUsername(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test//测试注解查询总用户数
    public void testFindByTotal(){
        int total = mapper.findTotal();
        System.out.println(total);
    }
}
