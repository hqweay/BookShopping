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
		response.setContentType("text/html;charset = utf-8");
		String bookClass = request.getParameter("bookClass");
		String bookId = request.getParameter("bookId");
        util.DbUtil dbUtil = new util.DbUtil();
        dao.BookDao dao = new dao.BookDao();
        java.sql.Connection connection = null;
        JSONObject object = new JSONObject();
        String curl = request.getRequestURI();
        String ctxPath = request.getContextPath();
        //除掉项目名称时访问页面当前路径
        String url = curl.substring(ctxPath.length());
        
        switch(url){
            case "/booktype/add":
            	  try {
         			 connection = dbUtil.getCon();
         			 int count = dao.insertBookClass(bookClass);
         			 System.out.println(count);
         			 if (count>0) {
         				 object.put("success", "true");
         			}else{
         				object.put("success", "true");
         				object.put("errorMsg", "添加失败，系统错误或者你想添加的书类已存在");
         				
         			}
         			response.setContentType("text/json;charset = utf-8");
         			PrintWriter out=response.getWriter();
         			out.println(object.toString());
         			out.flush();
         			out.close();
         		} catch (ClassNotFoundException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		} catch (SQLException e) {
         			// TODO Auto-generated catch block
         			
         			e.printStackTrace();
         		}
                break;
            case "/booktype/modify":
            	 try {
         			 connection = dbUtil.getCon();
         			 int count = dao.modifyBookClass(bookClass, Integer.parseInt(bookId));
         			 System.out.println(count);
         			if (count>0) {
         				 object.put("success", "true");
         				 object.put("successMsg", "修改成功");
         			}else{
         				object.put("success", "true");
         				object.put("errorMsg", "修改失败");
         				
         			}
         			response.setContentType("text/json;charset = utf-8");
         			PrintWriter out=response.getWriter();
         			out.println(object.toString());
         			out.flush();
         			out.close();
         		} catch (ClassNotFoundException e) {
         			// TODO Auto-generated catch block
         			e.printStackTrace();
         		} catch (SQLException e) {
         			// TODO Auto-generated catch block
         			
         			e.printStackTrace();
         		}
            	break;
            case "/booktype/delete":
            	 try {
         			 connection = dbUtil.getCon();
         			 int count = dao.deleteBookClass(Integer.parseInt(bookId));
         			 System.out.println(count);
         			if (count>0) {
         				 object.put("success", "true");
         				 object.put("successMsg", "删除成功");
         			}else{
         				object.put("success", "true");
         				object.put("errorMsg", "删除失败");
         			}
         			response.setContentType("text/json;charset = utf-8");
         			PrintWriter out=response.getWriter();
         			out.println(object.toString());
         			out.flush();
         			out.close();
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

	}
	
}
