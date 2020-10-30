package org.Swordsman.dao;

import org.Swordsman.domain.Account;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/20-9:16
 * @Description:
 */
public interface IAccountDao {
    /**
     * 查询所有账户 同时还有获取当前账户所属用户信息
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
