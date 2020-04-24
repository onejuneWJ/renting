package cn.edu.tf.interceptor;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.pojo.Admin;
import cn.edu.tf.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Constant.CURRENT_ADMIN);
        String uri=httpServletRequest.getRequestURI();
        String method=httpServletRequest.getMethod();
        if(user==null&&admin==null){
            if(method.equals("GET")&&!uri.contains("/admin")){
                return true;
            }
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
