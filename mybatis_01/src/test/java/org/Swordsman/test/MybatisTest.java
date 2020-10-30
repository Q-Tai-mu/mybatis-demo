package org.Swordsman.test;


import org.Swordsman.dao.IUserDao;
import org.Swordsman.domain.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest {
    public static void main(String[] args) {
        //1.读取配置文件
        try {
            InputStream in1 = MybatisTest.class.getResourceAsStream("SqlMapConfig.xml");
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            if (in == in1) {
                System.out.println("两者是呗同一个源进行导入的");
            } else {
                System.out.println("两者b是呗同一个源进行导入的");
            }
            //2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //3.使用工厂生产SqlSession对象
            SqlSession session = factory.openSession();
            //4.使用SqlSession对象创建Dao接口代理对象
            IUserDao mapper = session.getMapper(IUserDao.class);
            //5.执行dao中的方法
            List<user> list = mapper.findAll();
            for (user user : list) {
                System.out.println(user);
            }
            //6.释放资源
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
