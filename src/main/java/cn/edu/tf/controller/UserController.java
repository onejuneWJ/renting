package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.User;
import cn.edu.tf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author : 王俊
 * @date : 2019/9/26 18:04
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseData login(@RequestBody User user, HttpSession session) {
        ResponseData responseData = new ResponseData();
        //调用service层login方法，得到结果
        Map<String, Object> map = userService.login(user);
        //获取登录结果
        String result = (String)map.get("result");
        if (Constant.SUCCESS.equals(result)) {
            User user1 = (User)map.get("user");
            session.setAttribute("CURRENT_USER", user1);
            responseData.setMsg("success");
        }else {
            responseData.setMsg("failed");
        }
        return responseData;
    }
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("CURRENT_USER", null);
        return "redirect:/index.html";
    }
}
