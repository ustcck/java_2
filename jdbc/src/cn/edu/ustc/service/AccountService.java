package cn.edu.ustc.service;

import cn.edu.ustc.dao.AccountDao;
import cn.edu.ustc.dao.AccountDaoImp;
import cn.edu.ustc.exception.AccountException;
import cn.edu.ustc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ustcck on 2016/10/9.
 */
public class AccountService {
    //汇款方法：accountin收款人、accountout汇款人、money金额
    public void account(String accountIn, String accountOut, double money) throws AccountException {
        AccountDaoImp dao = new AccountDaoImp();

        Connection con = null;
        try {
            con = JdbcUtils.getConnection();
            con.setAutoCommit(false);//开启事务

            dao.accountOut(accountOut, money);
            dao.accountIn(accountIn, money);
        } catch (Exception e) {
            e.printStackTrace();

            //出现问题，进行事务回滚
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            throw new AccountException(e.getMessage());
        } finally {
            //事务提交
            //关闭con
            if (con != null) {
                try {
                    con.commit();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
