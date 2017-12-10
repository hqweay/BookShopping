package web.admin;

import model.BookClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/29.
 */
@WebServlet(name = "Customer")
public class Customer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("text/html;charset = utf-8");

        System.out.println("到这里了11...");


        dao.CustomerDao dao = new dao.CustomerDao();
        ArrayList<model.Customer> customers = null;

        try {
            customers = dao.getCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("admin/customerSet.jsp").forward(request, response);

    }
}
