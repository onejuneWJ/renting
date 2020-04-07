package cn.edu.tf.service.impl;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.UserDao;
import cn.edu.tf.pojo.User;
import cn.edu.tf.pojo.UserExample;
import cn.edu.tf.service.UserService;
import cn.edu.tf.utils.HttpUtils;
import cn.edu.tf.utils.MailUtil;
import cn.edu.tf.utils.Md5Util;
import cn.edu.tf.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 王俊
 * @date 2019/9/17 16:23
 **/
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> list = userDao.selectByExample(userExample);
        if (list.size() > 0) {
            //用户名存在
            User user1 = list.get(0);
            //MD5加密
            String psw = Md5Util.encodeByMd5(user.getPassword());
            if (psw.equals(user1.getPassword())) {
                //登录成功
                map.put("result", "success");
                map.put("user", user1);
            } else {
                map.put("result", "failed");

            }
        } else {
            map.put("result", "failed");
        }
        return map;
    }

    @Override
    public String register(User user) {
        //校验用户名和密码
        if ("".equals(user.getUsername()) || null == user.getUsername()) {
            return "用户名不能为空";
        }
        if ("".equals(user.getPassword()) || null == user.getPassword()) {
            return "密码不能为空";
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().
                andUsernameEqualTo(user.getUsername());
        List<User> userList = userDao.selectByExample(userExample);
        if (userList.size() > 0) {
            return "用户名已存在";
        } else {
            user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
            userDao.insertSelective(user);
            return "success";
        }
    }

    @Override
    public PageInfo<User> list(Integer page, Integer limit) {
        return PageHelper.startPage(page, limit, true).doSelectPageInfo(() -> userDao.selectByExample(new UserExample()));
    }

    @Override
    public Map<String, Object> sendVerifyCode(String num, String type) {
        Map<String, Object> map = new HashMap<>();
        String code = StringUtil.getNumberCode();
        System.out.println(code);
        boolean flag = false;
        switch (type) {
            case Constant.sendType.E:
                flag = MailUtil.sendMail(num, "尊敬的万家租房用户：\n\t您好，您的验证码为" + code, "万家安全邮箱验证");
                break;
            case Constant.sendType.P:
                flag = HttpUtils.sendCode(code,num);
                break;
        }
        if (flag) {
            map.put("code", code);
            map.put("msg", Constant.SUCCESS);
        } else {
            map.put("msg", Constant.FAILED);
        }
        return map;
    }

    @Override
    public String changeEmail(User user, String email) {
        user.setEmail(email);
        userDao.updateByPrimaryKeySelective(user);
        return Constant.SUCCESS;
    }

    @Override
    public String changePhone(User user, String phone) {
        user.setPhone(phone);
        userDao.updateByPrimaryKeySelective(user);
        return Constant.SUCCESS;
    }

    @Override
    public String changeNickname(User user, String nickname) {
        if(StringUtils.isEmpty(nickname)){
            return "昵称不能为空";
        }
        user.setNickname(nickname);
        userDao.updateByPrimaryKeySelective(user);
        return Constant.SUCCESS;
    }

    @Override
    public String checkPhone(String phone) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        List<User> users=userDao.selectByExample(userExample);
        return users.size()>0?"exist":"not exist";
    }

    @Override
    public String checkUsername(String username) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users=userDao.selectByExample(userExample);
        return users.size()>0?"exist":"not exist";
    }
}
