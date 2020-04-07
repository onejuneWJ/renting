package cn.edu.tf.interceptor;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.pojo.Admin;
import cn.edu.tf.pojo.User;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute("CURRENT_ADMIN");
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);
        if (user == null) {
            if (admin != null) {
                //如果当前登录的是管理员，可访问user下除了个人信息页面接口的其他
                if (uri.contains("user/info") || uri.contains("user/self")) {
                    httpServletResponse.sendRedirect("http://localhost:8080/renting/user_login.html");
                    return false;
                } else {
                    return true;
                }
            }

            httpServletResponse.sendRedirect("http://localhost:8080/renting/user_login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
