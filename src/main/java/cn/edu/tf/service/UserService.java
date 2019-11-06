package cn.edu.tf.service;

import cn.edu.tf.pojo.User;

import java.util.Map;

/**
 * @author : 王俊
 * @date : 2019/9/17 16:22
 **/
public interface UserService {

    /**
     * 用户登录
     *
     * @param user 登录用户
     * @return 登录结果
     */
    Map<String,Object> login(User user);

    /**注册
     * @param user 用户
     * @return 注册结果
     */
    String register(User user);
}
