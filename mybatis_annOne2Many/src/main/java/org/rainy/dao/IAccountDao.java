package org.rainy.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.rainy.domain.Account;

import java.util.List;

/**
 * @author wuangjing
 * @create 2020/5/24-10:16
 * @Description:
 */
public interface IAccountDao {

    /**
     * 查询所有账户，并且得到账户所属用户信息
     *
     * @return
     */
    @Select("select * from account ")
    @Results(id = "resultMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid", one = @One(select = "org.rainy.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    public List<Account> findAll();

    /**
     * 根据id查询账户
     *
     * @param userId
     * @return
     */
    @Select("select * from account where uid=#{userId}")
    public List<Account> findById(Integer userId);
}
