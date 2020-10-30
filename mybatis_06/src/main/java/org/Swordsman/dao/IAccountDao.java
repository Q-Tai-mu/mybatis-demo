package org.Swordsman.dao;

import org.Swordsman.domain.Account;
import org.Swordsman.domain.AccountUser;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/20-9:16
 * @Description:
 */
public interface IAccountDao {
    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有用户 并带有用户名称和用户地址信息
     *
     * @return
     */
    List<AccountUser> findAllAccount();
}
