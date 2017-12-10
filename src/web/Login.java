package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import model.Customer;

public class Login extends javax.servlet.http.HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        //解决中文输出乱码
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        try {
            util.DbUtil dbUtil = new util.DbUtil();
            CustomerDao dao = new CustomerDao();
            Connection connection = dbUtil.getCon();
            Customer customer = dao.getCustomerByName(connection, name);
            //此处验证空值交给js
            //验证都得验证 不然被抓包
            if (customer!=null&&password.equals(customer.getPassword())) {
                //验证密码成功  把customer绑定到seesion对象上
                HttpSession session = req.getSession();
                session.setAttribute("Customer", customer);
                //跳转至首页 这里甚至可以跳转至servlet

                resp.sendRedirect("/");



            }else{
                //重新绑定  发回客户端显示
                req.setAttribute("userName", name);
                req.setAttribute("password", password);
                req.setAttribute("errorMsg", "Your name or pass is wrong");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}
