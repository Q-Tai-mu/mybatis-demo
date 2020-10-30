package org.rainy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.rainy.domain.User;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/22-10:28
 * @Description:
 */
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("Select * from user")
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param intId
     */
    @Delete("delete  from user where id=#{id} ")
    void deleteUser(Integer intId);

    /**
     * 根据id查询用户
     *
     * @param intId
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer intId);

    /**
     * 更加名称模糊查询
     *
     * @param user
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByUsername(User user);

    /**
     * 查询总用户数
     *
     * @return
     */
    @Select("select count(id) from user ")
    int findTotal();
}
