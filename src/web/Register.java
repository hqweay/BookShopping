package web;

import dao.CustomerDao;
import model.Customer;
import util.DbUtil;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/11/6.
 */
public class Register extends javax.servlet.http.HttpServlet {
    DbUtil dbUtil = new DbUtil();
    CustomerDao customerDao = new CustomerDao();
    Customer customer = new Customer();
    private Connection con;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("password");

        customer.setName(userName);
        customer.setPassword(password);
        customer.setPhoneNum(Integer.parseInt(phoneNum));
        try {
            con = dbUtil.getCon();
            int test = customerDao.addCustomer(con, customer);
            if (test > 0) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);//跳转
            }


            dbUtil.closeCon(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
