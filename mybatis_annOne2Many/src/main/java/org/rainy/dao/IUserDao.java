package org.rainy.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.rainy.domain.User;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/22-10:28
 * @Description:
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("Select * from user")
    @Results(id = "resultMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "address", property = "userAddress"),
            @Result(property = "accounts", column = "id", many = @Many(select = "org.rainy.dao.IAccountDao.findById", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     *
     * @param intId
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"resultMap"})
    User findById(Integer intId);

    /**
     * 更加名称模糊查询
     *
     * @param user
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByUsername(User user);


}
