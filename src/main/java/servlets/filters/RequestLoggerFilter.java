package servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

@WebFilter("/*")
public class RequestLoggerFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(RequestLoggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("created RequestLoggerFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)){
            // nope
        } else {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse resp = (HttpServletResponse) servletResponse;

            LOG.info(String.format("User %s, request %s",
                    req.getSession().getAttribute("userName"),
                    req.getRequestURI()));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
