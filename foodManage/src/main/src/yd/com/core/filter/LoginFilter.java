/*
信息:
*/
package yd.com.core.filter;

import role.com.entity.Role;
import u.com.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String uri=request.getRequestURI();
        if (!(uri.contains("user_"))){
            User user=(User)request.getSession().getAttribute("admin");
             if (user!=null){
                 filterChain.doFilter(request,response);
             }else{
                 response.sendRedirect(request.getContextPath()+"/pages/info/all-admin-login.html");
             }
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
