package web.admin;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class BookType
 */

public class BookType extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset = utf-8");
		String bookClass = request.getParameter("bookClass");
		String bookId = request.getParameter("bookId");
        util.DbUtil dbUtil = new util.DbUtil();
        dao.BookDao dao = new dao.BookDao();
        java.sql.Connection connection = null;
        JSONObject object = new JSONObject();
        String curl = request.getRequestURI();
        String ctxPath = request.getContextPath();
        String url = curl.substring(ctxPath.length());
        switch(url){
        //书类增加
            case "/book-type/add":
            	  try {
         			 connection = dbUtil.getCon();
         			 int count = dao.insertBookClass(bookClass);
         			 System.out.println(count);
         			 if (count>0) {
         				 object.put("successMsg", "添加成功");
         			}else{
         				object.put("errorMsg", "添加失败，你想添加的书类可能已经存在");
         			}
         		} catch (ClassNotFoundException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		} catch (SQLException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		}
                break;
            //书类修改
            case "/book-type/modify":
            	 try {
         			 connection = dbUtil.getCon();
         			 int count = dao.modifyBookClass(bookClass, Integer.parseInt(bookId));
         			 System.out.println(count);
         			if (count>0) {
         				 object.put("successMsg", "修改成功");
         			}else{
         				object.put("errorMsg", "修改失败");
         				
         			}
         		} catch (ClassNotFoundException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		} catch (SQLException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		}
            	break;
            //书类删除
            case "/book-type/delete":
            	 try {
         			 connection = dbUtil.getCon();
         			 int count = dao.deleteBookClass(Integer.parseInt(bookId));
         			 System.out.println(count);
         			if (count>0) {
         				 object.put("successMsg", "删除成功");
         			}else{
         				object.put("errorMsg", "删除失败");
         			}
         		} catch (ClassNotFoundException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		} catch (SQLException e) {
         			// TODO Auto-generated catch block
         			
         			e.printStackTrace();
         		}
            	break;
                default:
                    break;
		
	}
        
            PrintWriter out=response.getWriter();
			out.println(object.toString());
			out.flush();
			out.close();

	}
	
}
