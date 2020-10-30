package org.Swordsman.dao;

import org.Swordsman.domain.User;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/16-9:38
 * @Description:
 */
public interface IUserDao {
    /**
     * 查询所有用户 同时获取到用户下所有账户的信息
     *
     * @return
     */
    List<User> findAll();
    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    User findById(Integer uid);

}
