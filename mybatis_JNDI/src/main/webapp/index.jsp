<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.Swordsman.dao.IUserDao" %>
<%@ page import="org.Swordsman.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1.读取配置文件
    try {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession对象创建Dao接口代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //5.执行dao中的方法
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>
