package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.Admin;
import cn.edu.tf.service.AdminService;
import cn.edu.tf.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/imageCode")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");
        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0, 0, width, height);

        //产生4个随机验证码，12Ey
        String checkCode = StringUtil.getCheckCode();
        //将验证码放入HttpSession中
        request.getSession().setAttribute(Constant.ADMIN_LOGIN_CODE, checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    @GetMapping("/checkVerifyCode")
    @ResponseBody
    public ResponseData<?> checkVerifyCode(String code, HttpServletRequest request) {
        String loginCode = (String) request.getSession().getAttribute(Constant.ADMIN_LOGIN_CODE);
        return loginCode.toLowerCase().equals(code.toLowerCase()) ? ResponseData.ok(null, Constant.SUCCESS) : ResponseData.ok(null, Constant.FAILED);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseData<?> login(@RequestBody Admin admin, HttpSession session) {
        Map<String, Object> map = adminService.login(admin);
        String result = (String) map.get("msg");
        if (Constant.SUCCESS.equals(result)) {
            session.setAttribute(Constant.CURRENT_ADMIN, map.get("admin"));
            return ResponseData.ok(null, Constant.SUCCESS);
        } else {
            return ResponseData.ok(null, result);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute(Constant.CURRENT_ADMIN,null);
        return "redirect:/admin_login.html";
    }
    @GetMapping("/index")
    public String toIndex() {
        return "admin/index";
    }
}
