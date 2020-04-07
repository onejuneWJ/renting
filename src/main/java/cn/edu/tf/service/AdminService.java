package cn.edu.tf.service;

import cn.edu.tf.pojo.Admin;

import java.util.Map;

public interface AdminService {
    Map<String, Object> login(Admin admin);
}
