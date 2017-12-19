package web.admin;

import dao.ManagerDao;
import util.DbUtil;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/12/2.
 */
@WebServlet(name = "Manager")
public class Manager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.Manager manager = new model.Manager();
        manager.setName(request.getParameter("name"));
        manager.setPassword(request.getParameter("password"));

        //获取旧管理员信息  有必要这样吗？
        HttpSession session = request.getSession();
        model.Manager oldManager = (model.Manager)session.getAttribute("manager");
        /*
                  若账号密码都没改动 提示出错
                 一者改动 另一者继承原数据
        */
        if(manager.getName() == "" && manager.getPassword() == ""){
            request.setAttribute("errorMsg", "You have not change any option");
            request.getRequestDispatcher("Manager.jsp").forward(request, response);
            return ;
        }else if(manager.getName() == ""){
            manager.setName(oldManager.getName());
            return ;
        }else if(manager.getPassword() == ""){
            manager.setPassword(oldManager.getPassword());
            return ;
        }

        ManagerDao dao = new ManagerDao();

        try {
            if(dao.setManager(manager, oldManager) > 0){
                //更新成功
                //清除session中的Manager 判断一下？
                session.removeAttribute("manager");
                request.setAttribute("loginMsg", "Yes!!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }else{
                request.setAttribute("errorMsg", "Sorry error!!");

                //下面请求资源路径方式值得注意
                request.getRequestDispatcher("Manager.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
