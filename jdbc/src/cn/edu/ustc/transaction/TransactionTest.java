package cn.edu.ustc.transaction;

import cn.edu.ustc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TransactionTest事务操作
 * Created by ustcck on 2016/10/8.
 */
public class TransactionTest {
    public static void main(String[] args) throws SQLException {
        String sql = "update account set money=500 where id=2";

        Connection connection = JdbcUtils.getConnection();
        connection.setAutoCommit(false); //start transaction

        Statement st= connection.createStatement();
        st.executeUpdate(sql);

//        connection.rollback();

        connection.commit();
        st.close();
        connection.close();

    }

}
