package cn.edu.ustc.dao;

/**
 * AccountDao
 * Created by ustcck on 2016/10/9.
 */
public interface AccountDao {
    public void accountOut( String accountOut, double money) throws Exception;

    //从accountIn账号转入money
    public void accountIn(String accountIn, double money) throws Exception;


}
