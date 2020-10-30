package org.Swordsman.dao;

import org.Swordsman.domain.Role;
import org.Swordsman.domain.User;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/20-14:48
 * @Description:
 */
public interface IRoleDao {

    /**
     * 查询所有角色  同时获取所赋予的用户信息
     * @return
     */
    List<Role> findAll();


}
