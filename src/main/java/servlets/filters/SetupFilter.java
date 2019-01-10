package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SetupFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.setAttribute("lang",
                ((HttpServletRequest) servletRequest).getSession().getAttribute("lang"));
        filterChain.doFilter(servletRequest, servletResponse); // TODO Зачем? Разве не везде из сессии?
    }

    @Override
    public void destroy() {

    }
}
