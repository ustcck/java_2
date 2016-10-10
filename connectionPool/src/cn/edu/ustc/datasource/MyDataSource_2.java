package cn.edu.ustc.datasource;

import cn.edu.ustc.utils.JdbcUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 自定义连接池必须实现DataSource接口。
 * Created by ustcck on 2016/10/9.
 */
public class MyDataSource_2 implements DataSource {

    private LinkedList<Connection> ll;//connection对象的容器

    public MyDataSource_2() throws SQLException {
        ll = new LinkedList<Connection>();

        for (int i = 0; i < 5; i++) {
            Connection con = JdbcUtils.getConnection();
            ll.add(con);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (ll.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Connection con = JdbcUtils.getConnection();
                ll.add(con);
            }
        }
        return ll.removeFirst();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    //将Connection对象重新装入
    public void readd(Connection con) {
        ll.addLast(con);
    }

    public int getsize() {
        return ll.size();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
