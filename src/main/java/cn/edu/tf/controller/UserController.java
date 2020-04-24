package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.UserDao;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.dto.PageRequest;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.Deal;
import cn.edu.tf.pojo.User;
import cn.edu.tf.service.DealService;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.service.UserService;
import cn.edu.tf.utils.Md5Util;
import cn.edu.tf.utils.StringUtil;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author : 王俊
 * @date : 2019/9/26 18:04
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private DealService dealService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseData login(@RequestBody User user, HttpSession session) {
        ResponseData responseData = new ResponseData();
        //调用service层login方法，得到结果
        Map<String, Object> map = userService.login(user);
        //获取登录结果
        String result = (String) map.get("result");
        if (Constant.SUCCESS.equals(result)) {
            User user1 = (User) map.get("user");
            session.setAttribute("CURRENT_USER", user1);
            responseData.setMsg("success");
        } else {
            responseData.setMsg("failed");
        }
        return responseData;
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("CURRENT_USER", null);
        return "redirect:/index.html";
    }

    @GetMapping("/self")
    public String self() {
        return "user/index";
    }

    @GetMapping("/info")
    public String info() {
        return "user/info";
    }

    @PostMapping("/modifyPassword")
    @ResponseBody
    public String modifyPassword(@RequestBody String body, HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (Objects.isNull(user)) {
            return "请登录";
        }
        JSONObject jsonObject = new JSONObject(body);
        String oldPassword = jsonObject.getString("oldPassword");
        String password = jsonObject.getString("password");
        String password2 = jsonObject.getString("password2");
        if (!user.getPassword().equals(Md5Util.encodeByMd5(oldPassword))) {
            return "原始密码错误，请重新输入";
        }
        if (StringUtils.isEmpty(password2) || StringUtils.isEmpty(password2)) {
            return "输入不能为空";
        }
        if (!Pattern.matches("^[a-zA-Z]\\w{5,17}", password)) {
            return "新密码格式不正确";
        }
        if (!password.equals(password2)) {
            return "两次密码输入不一致";
        }
        user.setPassword(Md5Util.encodeByMd5(password));
        userDao.updateByPrimaryKeySelective(user);
        return Constant.SUCCESS;
    }

    @PostMapping("/uploadAvatar")
    @ResponseBody
    public ResponseData<?> upload(@RequestParam("file") MultipartFile multipartFile, HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("CURRENT_USER");
        if (user == null) {
            return new ResponseData<>(ResponseData.CODE_ERROR, "session失效，请重新登录", "");
        }
        if (multipartFile.isEmpty()) {
            return new ResponseData<>(ResponseData.CODE_ERROR, "文件不存在", null);
        }
        String fileName = multipartFile.getOriginalFilename();
        String path = "D:/MyFile/uploadFiles/" + fileName;
        File file = new File(path);
        multipartFile.transferTo(file);
        user.setAvatar(fileName);
        userDao.updateByPrimaryKey(user);
        return ResponseData.ok(null, Constant.SUCCESS);
    }

    /**
     * 用户列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping
    @ResponseBody
    public ResponseData<List<User>> list(Integer page, Integer limit) {
        return ResponseData.pageOk(userService.list(page, limit));
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping
    @ResponseBody
    public ResponseData<?> update(@RequestBody User user){
        System.out.println(user);
        String msg=userService.update(user);
        return ResponseData.ok(null,msg);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseData<?> delete(@PathVariable Long id){
        String msg=userService.delete(id);
        return ResponseData.ok(null,msg);
    }

    /**
     * 我的发布
     */
    @GetMapping("/myPost")
    @ResponseBody
    public ResponseData<List<HouseDTO>> myPost(HttpSession session, Integer page, Integer limit) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (Objects.isNull(user)) {
            return ResponseData.ok(null);
        }
        return ResponseData.pageOk(houseService.myPost(user.getId(), page, limit));
    }

    /**
     * 我的交易
     */
    @GetMapping("/myDeal")
    @ResponseBody
    public ResponseData<List<Deal>> myDeal(HttpSession session, PageRequest pageRequest) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (Objects.isNull(user)) {
            return ResponseData.ok(null);
        }
        return ResponseData.pageOk(dealService.myDeal(user.getId(), pageRequest.getPage(), pageRequest.getLimit()));
    }

    /**
     * @param number  电话/邮箱
     * @param type    验证码发送类型（电话/邮箱）
     * @param session session
     * @return 返回结果
     */
    @GetMapping("/sendCode")
    @ResponseBody
    public ResponseData<String> sendCode(String number, String type, HttpSession session) {
        Map<String, Object> map = userService.sendVerifyCode(number, type);
        String msg = (String) map.get("msg");
        String code = (String) map.get("code");
        if (Constant.SUCCESS.equals(msg)) {
            session.setAttribute("CODE", code);
        } else {
            session.setAttribute("CODE", null);
        }
        return ResponseData.ok(code, msg);
    }

    @GetMapping("/changeEmail")
    @ResponseBody
    public ResponseData<String> changeEmail(String email, HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        return ResponseData.ok(null, userService.changeEmail(user, email));
    }

    @GetMapping("/changePhone")
    @ResponseBody
    public ResponseData<String> changePhone(String phone, HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        return ResponseData.ok(null, userService.changePhone(user, phone));
    }

    @GetMapping("/changeNickname")
    @ResponseBody
    public ResponseData<String> changeNickname(String nickname, HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        return ResponseData.ok(null, userService.changeNickname(user, nickname));
    }

    @GetMapping("/cp")
    @ResponseBody
    public ResponseData<String> checkPhone(String phone) {
        return ResponseData.ok(null, userService.checkPhone(phone));
    }

    @GetMapping("/cu")
    @ResponseBody
    public ResponseData<String> checkUsername(String username) {
        return ResponseData.ok(null, userService.checkUsername(username));
    }
}
