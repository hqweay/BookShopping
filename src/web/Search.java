package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends javax.servlet.http.HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset = utf-8");
    	String method = request.getParameter("method");
    	String param = request.getParameter("searchParam");
    	dao.BookDao dao = new dao.BookDao();
    	List<model.Book> books = null;
    	System.out.println(param);
    	if ("byAuthor".equals(method)) {
			books = dao.searchBookByAuthor(param);
		}else{
			books = dao.searchBookByName(param);
		}
    	System.out.println(books);
    	request.setAttribute("books", books);
    	request.getRequestDispatcher("search-page.jsp").forward(request, response);
    }
}
