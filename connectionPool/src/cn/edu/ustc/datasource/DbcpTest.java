package cn.edu.ustc.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DbcpTest,dbcp是apache的一个开源连接池。
 * 要想使用DBCP连接池，要下载jar包,导入时要导入两个commons-dbcp-1.4.jar、commons-pool-1.5.6.jar
 * Created by ustcck on 2016/10/10.
 */
public class DbcpTest {
    //手动配置
    @Test
    public void test_1() throws SQLException {
        BasicDataSource bds = new BasicDataSource();

        // 需要设置连接数据库最基本四个条件

        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql:///ustcck");
        bds.setUsername("root");
        bds.setPassword("123");

        Connection con = bds.getConnection();
        //操作
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM account");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
        }

        rs.close();
        con.close();
    }

    @Test
    public void test_2() throws Exception {
        Properties properties = new Properties();

        FileInputStream inputStream = new FileInputStream("C:\\Users\\ustcck\\IdeaProjects\\connectionPool\\src\\dbcp.properties");
        properties.load(inputStream);

        DataSource ds = BasicDataSourceFactory.createDataSource(properties);

        Connection con = ds.getConnection();
        //操作
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM account");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
        }

        rs.close();
        con.close();
    }
}
