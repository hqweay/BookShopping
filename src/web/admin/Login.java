package web.admin;

import dao.CustomerDao;
import dao.ManagerDao;
import model.Customer;
import model.Manager;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Login extends javax.servlet.http.HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        Manager manager = new Manager();
        manager.setName(req.getParameter("name"));
        manager.setPassword(req.getParameter("password"));
        DbUtil util = new DbUtil();
        ManagerDao dao = new ManagerDao();
        try {
            Connection con = util.getCon();
            if(dao.isManager(con, manager)){
                HttpSession session = req.getSession();
                session.setAttribute("manager", manager);
                //resp.sendRedirect("/admin/Manager.jsp");
                //resp.sendRedirect("Manager.jsp");
                //resp.sendRedirect("Manager.jsp");
                req.setAttribute("type", "layout/center-manager.jsp");
                req.getRequestDispatcher("/admin/Index.jsp").forward(req, resp);
            }else{
                req.setAttribute("errorMsg", "Your name or password is wrong");
                //req.getRequestDispatcher("/admin/Login.jsp").forward(req, resp);
                req.getRequestDispatcher("/admin/Login.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
