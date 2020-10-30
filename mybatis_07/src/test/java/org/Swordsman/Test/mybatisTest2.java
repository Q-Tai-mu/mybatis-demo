package org.Swordsman.Test;

import org.Swordsman.dao.IRoleDao;
import org.Swordsman.domain.Role;
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
 * @create 2020/5/20-15:02
 * @Description:
 */
public class mybatisTest2 {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao mapper;

    @Before//测试执行前执行
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(IRoleDao.class);
    }

    @After//测试执行后执行
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test//测试查询所有角色 同时获取所赋予的用户信息
    public void findRoleAll(){
        List<Role> roles = mapper.findAll();
        for (Role role : roles) {
            System.out.println("----每个角色----");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
