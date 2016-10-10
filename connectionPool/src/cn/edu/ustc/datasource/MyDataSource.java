package cn.edu.ustc.datasource;

import cn.edu.ustc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * MyDataSource
 * Created by ustcck on 2016/10/9.
 */
public class MyDataSource {

    private LinkedList<Connection> ll;//connection对象的容器

    public MyDataSource() throws SQLException {
        ll = new LinkedList<Connection>();

        for (int i = 0; i < 5; i++) {
            Connection con = JdbcUtils.getConnection();
            ll.add(con);
        }
    }

    //获取连接方法
    public Connection getConnection() throws SQLException {

        if (ll.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Connection con = JdbcUtils.getConnection();
                ll.add(con);
            }
        }
        return ll.removeFirst();
    }

    //将Connection对象重新装入
    public void readd(Connection con) {
        ll.addLast(con);
    }

    public int getsize() {
        return ll.size();
    }
}
