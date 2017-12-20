package web.admin;

import dao.BookDao;
import model.BookClass;
import net.sf.json.JSONObject;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lenovo on 2017/12/10.
 */
public class Book extends HttpServlet {
    model.Book book = new model.Book();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        response.setContentType("text/json;charset = utf-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String writer = request.getParameter("author");
        String img = request.getParameter("img");
        String description = request.getParameter("describe");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String quantity =request.getParameter("quantity");
        String id = request.getParameter("id");

        util.DbUtil dbUtil = new util.DbUtil();
        BookDao dao = new BookDao();
        String curl = request.getRequestURI();
        String ctxPath = request.getContextPath();
        String url = curl.substring(ctxPath.length());
        JSONObject object = new JSONObject();

        switch (url) {
            case "/book/add":

                book.setName(name);
                book.setAuthor(writer);
                book.setUrl(img);
                book.setDescrible(description);
                if(type == ""){
                    book.setType(1);
                }
                if(quantity == ""){
                    book.setQuantity(10);
                }
                if(discount == ""){
                    book.setDiscount(5);
                }
                if(price == ""){
                    book.setPrice(10);
                }
                if(img == ""){
                    book.setDescrible("一本有趣的小黄书");
                }

                if(description == ""){
                    book.setUrl("image/xiaoshuo_05.jpg");
                }

                if(name == "" || writer == ""){
                    object.put("successMsg", "你干嘛？抓包？");
                    return;
                }
//                book.setType(Integer.parseInt(type));
//                book.setQuantity(Integer.parseInt(quantity));
//                book.setDiscount(Float.parseFloat(discount));
//                book.setPrice(Float.parseFloat(price));

                //还需要一个判断是否已有该书的逻辑
                try {
                    Connection connection = dbUtil.getCon();
                    if (dao.addBook(connection, book)) {
                        //成功
                        object.put("successMsg", "加入成功！！");
                    }else{
                        //失败
                        object.put("errorMsg", "加入失败！");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/book/get" :
                try {
                    Connection connection = dbUtil.getCon();
                    book = dao.getBookByid(connection, Integer.parseInt(id));

                    object.put("name", book.getName());
                    object.put("author", book.getAuthor());
                    object.put("describe", book.getDescrible());
                    object.put("discount", book.getDiscount());
                    object.put("price", book.getPrice());
                    object.put("quantity", book.getQuantity());
                    object.put("type", book.getType());
                    object.put("img", book.getUrl());



                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "/book/set" :
                //修改
                break;
        }
        PrintWriter out=response.getWriter();
        out.println(object.toString());
        out.flush();
        out.close();

    }
}

