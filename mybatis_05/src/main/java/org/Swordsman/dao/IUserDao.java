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
     * 根据QueryVo包装类查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数动态条件查询
     * @param user 查询条件：有可能有用户名，有可能有性别，也有可能没有条件
     * @return
     */
    List<User> findUserByConditions(User user);

    /**
     * 根据传入的子查询条件查询
     * @param vo
     * @return
     */
    List<User> findUserQueryVo(QueryVo vo);
}
