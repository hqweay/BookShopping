package filter.admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenovo on 2017/12/3.
 */
@WebFilter(filterName = "Manager")
public class Manager extends HttpServlet implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        model.Manager manager = (model.Manager) session.getAttribute("manager");
        //获取当前页面地址
        String currentURL = request.getRequestURI();
        String ctxPath = request.getContextPath();
        //除掉项目名称时访问页面当前路径
        String targetURL = currentURL.substring(ctxPath.length());

        //System.out.println(targetURL);

        if(manager != null){
            System.out.println(manager.getName());
        }

        /*
        * 不能少这行代码，不然就相当于把request， response丢失了
        * 详细
        * http://blog.csdn.net/a630895452/article/details/73076948
        * */
        //不得不说 我真牛逼
        //  ^v^   笑一个
        if(!("/admin/Login.jsp".equals(targetURL)) && !("/admin/Login").equals(targetURL)){
            if(manager == null){
                //request.setAttribute("errorMsg", "You have not entered");
                //request.getRequestDispatcher("/admin/Login.jsp").forward(request, response);
                response.sendRedirect("/admin/Login.jsp");
                //chain.doFilter(request, response);
            }else{
                chain.doFilter(request, response);
            }
        }else{
            chain.doFilter(request, response);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
