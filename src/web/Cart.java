package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import model.Book;
import model.Customer;
import util.DbUtil;

/**
 * service for the shoppinng car request
 * @author zhangbo
 *
 */
public class Cart extends javax.servlet.http.HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request .getSession();
		Customer customer = (Customer)session.getAttribute("Customer");
		
		if (customer == null) {
			System.out.println("sys null");
		}
		DbUtil dbUtil = new util.DbUtil();
		CustomerDao dao = new CustomerDao();
		Connection con = null;
		if (dao == null) {
			System.out.println("1111111111111");
		}
		try {
			con = dbUtil.getCon();
			List<Book> books = dao.getCartListByName(con, customer.getName());
			
			session.setAttribute("Books", books);
			response.sendRedirect("ShoppingCar.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
