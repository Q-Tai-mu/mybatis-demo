package org.Swordsman.Test;

import org.Swordsman.dao.IAccountDao;
import org.Swordsman.domain.Account;
import org.Swordsman.domain.AccountUser;
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
public class mybatisTest2 {
    public InputStream in;
    public SqlSessionFactory factory;
    public SqlSession session;
    public IAccountDao mapper;

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

    @Test//查询所有账户
    public void testFindAll(){
        List<Account> accounts = mapper.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    @Test//查询所有用户 并带有用户名称和用户地址信息
    public void testFindAllAccount(){
        List<AccountUser> accountUsers = mapper.findAllAccount();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);

        }
    }

}
