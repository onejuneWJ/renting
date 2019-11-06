package cn.edu.tf.service.impl;

import cn.edu.tf.dao.UserDao;
import cn.edu.tf.pojo.User;
import cn.edu.tf.pojo.UserExample;
import cn.edu.tf.service.UserService;
import cn.edu.tf.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            userDao.insertSelective(user);
            return "success";
        }
    }
}
