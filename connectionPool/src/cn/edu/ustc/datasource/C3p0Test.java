package cn.edu.ustc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * C3p0Test(必会),C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。
 * 目前使用它的开源项目有Hibernate，Spring等。
 * 		dbcp没有自动回收空闲连接的功能
 * 		c3p0有自动回收空闲连接功能
 * Created by ustcck on 2016/10/10.
 */
public class C3p0Test {
    @Test
    public void test_1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql:///ustcck");
        cpds.setUser("root");
        cpds.setPassword("123");

        Connection con = cpds.getConnection();
        //操作
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM account");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
        }

        rs.close();
        con.close();
    }

    @Test
    public void test_2() throws SQLException {

        ComboPooledDataSource cpds = new ComboPooledDataSource();


        Connection con = cpds.getConnection();
        //操作
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM account");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
        }

        rs.close();
        con.close();
    }
}
