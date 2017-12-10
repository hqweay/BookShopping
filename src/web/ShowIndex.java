package web;

import dao.BookDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowIndex extends javax.servlet.http.HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("text/html;charset = utf-8");
        //这里获取请求地址  处理不同的请求
        //StringBuffer url = request.getRequestURL();
        //截取到请求的书类的id 返回相关书类的页面
        //String sub = url.substring(url.lastIndexOf("/"),url.indexOf("."));
        //if("/1".equals(sub)){
        //返回书类id为1的页面
        //}
        //if("/2".equals(sub)){
        //返回书类id为2的页面
        //}
        // System.out.println(sub);
        BookDao daoBook = new BookDao();
        BookDao daoBookType = new BookDao();
        //获取书类型
        List<model.BookClass> bookList = daoBookType.getBookClass();
        //每种类型获取几本书
        java.util.HashMap<String, List<model.Book>> map  = new java.util.HashMap<>();;
        System.out.println(bookList.size());
        for(int i = 0; i<bookList.size();i++){
            List<model.Book> books = daoBook.getBookListById(bookList.get(i).getId());
            //以id命名 发送books回前端
            System.out.println(books);
            map.put(bookList.get(i).getBookClassParam(),books);
        }
        request.setAttribute("map", map);
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
