package org.Swordsman.dao;

import org.Swordsman.domain.QueryVo;
import org.Swordsman.domain.User;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/16-9:38
 * @Description:
 */
public interface IUserDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    User findById(Integer uid);

    /**
     * 根据用户模糊查询用户
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总记录数
     * @return
     */
    int findByTotal();

    /**
     * 根据QueryVo包装类查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
