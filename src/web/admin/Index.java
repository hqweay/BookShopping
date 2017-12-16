package web.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import model.Book;
import model.BookClass;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/12/3.
 */
@WebServlet(name = "Index")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 根据传来参数不同 返回不同的路径
         * 由此来实现index显示不同的页面
         */
        //resp.setCharacterEncoding("text/html;charset = utf-8");

        //这里获取请求地址  处理不同的请求
        //获取当前页面地址
        String curl = req.getRequestURI();
        String ctxPath = req.getContextPath();
        //除掉项目名称时访问页面当前路径
        String url = curl.substring(ctxPath.length());
        System.out.println(url);
        BookDao dao = new BookDao();
        switch(url){
            case "/test/manager":
                req.setAttribute("type", "layout/center-manager.jsp");
                req.getRequestDispatcher("/admin/Index.jsp").forward(req, resp);
                break;
            case "/test/book-type":

            	List<BookClass> bookTypes = dao.getBookClass();
            	req.setAttribute("bookTypes", bookTypes);
            	req.setAttribute("type", "layout/center-book-type.jsp");
            	req.getRequestDispatcher("/admin/Index.jsp").forward(req, resp);
                break;
            case "/test/book":

                Map<String, List<Book>> booksMap = dao.getAllBooks();

                req.setAttribute("booksMap", booksMap);
                req.setAttribute("type", "layout/center-book.jsp");
                req.getRequestDispatcher("/admin/Index.jsp").forward(req, resp);

                break;

            	default:
                    break;

        }



        //req.setAttribute("type", "layout/");
    }
}
