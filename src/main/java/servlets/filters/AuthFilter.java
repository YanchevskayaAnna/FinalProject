package servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/adminview/*")//Защищаемае часть
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        //Существует ли сессия
        boolean loggedIn = session != null && session.getAttribute("userName") != null && session.getAttribute("userRole") != null;
        if (loggedIn ){
            //Если существует то получаем роль
            String userRole = session.getAttribute("userRole").toString();
            if (userRole.equals("user")){
                response.sendRedirect(request.getContextPath() + "/userview/user.jsp");
            }else if (userRole.equals("admin")){
                response.sendRedirect(request.getContextPath() + "/adminview/admin.jsp");
            }
            //Если нет то на страницу входа.
        }else response.sendRedirect(request.getContextPath() + "/InvateServlet");
    }

    @Override
    public void destroy() {

    }
}
