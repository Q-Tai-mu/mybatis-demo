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
import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/23-14:40
 * @Description:
 */
public class mybatisOne2 {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before//测试前执行
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);

    }

    @After//测试后执行
    public void destroy() throws IOException {
        in.close();
    }

    @Test//测试注解根据id查询用户
    public void testFindById() {
        SqlSession session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = mapper.findById(48);
        System.out.println(user);

        session.close();//释放一级缓存

        SqlSession session2 = factory.openSession();
        IUserDao mapper2 = session2.getMapper(IUserDao.class);
        User user2 = mapper2.findById(48);
        System.out.println(user2);

    }


}
