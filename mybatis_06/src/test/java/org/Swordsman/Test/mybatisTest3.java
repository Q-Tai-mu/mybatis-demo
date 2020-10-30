package org.Swordsman.Test;

import org.Swordsman.dao.IAccountDao;
import org.Swordsman.dao.IUserDao;
import org.Swordsman.domain.Account;
import org.Swordsman.domain.AccountUser;
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
import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/20-9:20
 * @Description:
 */
public class mybatisTest3 {
    public InputStream in;
    public SqlSessionFactory factory;
    public SqlSession session;
    public IUserDao mapper;

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

    @Test//查询所有账户
    public void testFindAll(){
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

}
