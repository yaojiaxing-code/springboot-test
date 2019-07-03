package cn.practice.test.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//加@Component注解会让filter再初始化一次导致拦截路径变为拦截所有
@WebFilter(urlPatterns = "/hello1.html",filterName = "myFilter")
public class DenLuFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        System.out.println(request);
        Cookie[] cookies = request.getCookies();
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName()+" "+cookie.getValue());
            }
            for (Cookie cookie : cookies) {
                //有denLu这个cookie，并且其值非空
                if("denLu".equals(cookie.getName())&&cookie.getValue()!=null&&(!"logout".equals(cookie.getValue()))){
                    //放行
                    System.out.println(cookie.getName());
                    System.out.println(cookie.getValue());
                    System.out.println("filter放行");
                    filterChain.doFilter(request,servletResponse);
                    return;
                }
            }
            response.sendRedirect("/denlu.html");
        }else {
            System.out.println("拦截了");
            //request.getRequestDispatcher("/denlu.html").forward(request,servletResponse);
            response.sendRedirect("/denlu.html");
        }
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁destroy");
    }
}
