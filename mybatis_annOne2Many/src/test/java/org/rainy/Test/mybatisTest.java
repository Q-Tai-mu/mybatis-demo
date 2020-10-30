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
            System.out.println("---每个用户信息---");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


    @Test//测试注解根据id查询用户
    public void testFindById(){
        User user = mapper.findById(48);
        System.out.println(user);
    }

    @Test//测试注解模糊查询
    public void testFindByUsername(){
        User user = new User();
        user.setUserName("%王%");
        List<User> users = mapper.findByUsername(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }


}
