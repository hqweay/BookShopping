package web.admin;

import model.BookClass;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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

public class Customer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/json;charset=utf-8");
    	String curl = request.getRequestURI();
        System.out.println(curl);
        String page = request.getParameter("page");
        util.DbUtil dbUtil = new util.DbUtil();
        dao.CustomerDao customerDao = new dao.CustomerDao();
        switch (curl) {
		case "/customer/next-page":
			try {
				int start = Integer.parseInt(page)*10;
				JSONArray jsonArray = util.JsonUtil.formatRsToJsonArray(customerDao.getUserResultSet(start, 10));
				java.io.PrintWriter writer = response.getWriter();
				writer.println(jsonArray);
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/customer/last-page":
			try {
				int start = (Integer.parseInt(page)-2)*10;
				JSONArray jsonArray = util.JsonUtil.formatRsToJsonArray(customerDao.getUserResultSet(start, 10));
				java.io.PrintWriter writer = response.getWriter();
				writer.println(jsonArray);
				writer.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "/customer/delete":
			try {
				JSONObject obj = new JSONObject();
				String customerId = request.getParameter("id");
				int count = customerDao.deleteCustomer(Integer.parseInt(customerId));
				if (count>0) {
					obj.put("successMsg", "删除成功");
				}else{
					obj.put("errorMsg", "删除失败，请稍后重试");
				}
				java.io.PrintWriter writer = response.getWriter();
				writer.println(obj);
				writer.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "/customer/modify":
			try {
				JSONObject obj = new JSONObject();
				String customerId = request.getParameter("id");
				String cusName = request.getParameter("customerName");
				String cusAddress = request.getParameter("customerAddress");
				String cusNum = request.getParameter("customerNumber");
				model.Customer customer = new model.Customer();
				customer.setAddress(cusAddress);
				customer.setName(cusName);
				customer.setPhoneNum(Integer.parseInt(cusNum));
				customer.setId(Integer.parseInt(customerId));
				int count = customerDao.modifyCustomer(customer);;
				if (count>0) {
					obj.put("successMsg", "修改成功");
				}else{
					obj.put("errorMsg", "修改失败，请稍后重试");
				}
				java.io.PrintWriter writer = response.getWriter();
				writer.println(obj);
				writer.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "/customer/search":
			String method = request.getParameter("method");
			String searchValue = request.getParameter("searchValue");
			java.sql.ResultSet set = null;
			JSONArray jsonArray = null;
			if ("byName".equals(method)) {
				try {
					set = customerDao.searchCustomerByName(dbUtil.getCon(), searchValue);
					 jsonArray = util.JsonUtil.formatRsToJsonArray(set);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try{
					set = customerDao.searchCustomerByNUm(dbUtil.getCon(), Integer.parseInt(searchValue));
					 jsonArray = util.JsonUtil.formatRsToJsonArray(set);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println(jsonArray);
			java.io.PrintWriter writer = response.getWriter();
			writer.println(jsonArray);
			writer.close();
			break;
		default:
			break;
		}
    }
}
