package org.rainy.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rainy.dao.IAccountDao;
import org.rainy.dao.IUserDao;
import org.rainy.domain.Account;
import org.rainy.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/23-14:40
 * @Description:
 */
public class mybatisAccount {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao mapper;

    @Before//测试前执行
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(IAccountDao.class);
    }

    @After//测试后执行
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test//测试注解查询
    public void testFindAll() {
        List<Account> accounts = mapper.findAll();
        for (Account account : accounts) {
            System.out.println("---每个账户信息---");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }



}
