package cn.edu.tf.service;

import cn.edu.tf.pojo.User;
import com.github.pagehelper.PageInfo;

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

    PageInfo<User> list(Integer page, Integer limit);

    Map<String, Object> sendVerifyCode(String email, String type);

    String changeEmail(User user, String email);

    String changePhone(User user, String phone);

    String changeNickname(User user, String nickname);

    String checkPhone(String phone);

    String checkUsername(String username);

    String update(User user);

    String delete(Long id);
}
