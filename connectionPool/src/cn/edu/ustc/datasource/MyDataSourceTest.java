package cn.edu.ustc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MyDataSourceTest
 * 测试自己定义的连接池
 * Created by ustcck on 2016/10/9.
 */
public class MyDataSourceTest {

    public static void main(String[] args) throws SQLException {
        MyDataSource mds = new MyDataSource();

        //创建一个连接对象
        Connection con = mds.getConnection();
        //操作
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM account");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
        }

        rs.close();

        //将连接对象重新装入到连接池
        mds.readd(con);

        System.out.println(mds.getsize());

    }
}
