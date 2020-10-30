package org.Swordsman.dao;

import org.Swordsman.domain.user;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户操作
     * @return
     */
    @Select("select * from user")
    public List<user> findAll();
}
