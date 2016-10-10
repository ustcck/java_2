package cn.edu.ustc.web.servlet;

import cn.edu.ustc.exception.AccountException;
import cn.edu.ustc.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AccountServlet
 * Created by ustcck on 2016/10/7.
 */
@WebServlet(name = "AccountServlet", urlPatterns = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //1.获取请求参数
        String accountIn = request.getParameter("accountin");
        String accountOut = request.getParameter("accountout");

        double money = Double.parseDouble(request.getParameter("money"));

        //2.调用service，完成汇款操作
        AccountService service = new AccountService();
        try {
            service.account(accountIn, accountOut, money);
            response.getWriter().write("转账成功");
            return;

        } catch (AccountException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
