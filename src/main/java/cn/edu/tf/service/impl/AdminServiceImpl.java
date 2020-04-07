package cn.edu.tf.service.impl;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.AdminDao;
import cn.edu.tf.pojo.Admin;
import cn.edu.tf.pojo.AdminExample;
import cn.edu.tf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Map<String, Object> login(Admin admin) {
        Map<String,Object> map=new HashMap<>();
        AdminExample adminExample=new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(admin.getAccount());
        List<Admin> adminList =adminDao.selectByExample(adminExample);
        if(adminList.size()>0){
            Admin adm=adminList.get(0);
            if(adm.getPassword().equals(admin.getPassword())){
                map.put("msg", Constant.SUCCESS);
                map.put("admin",adm);
            }else {
                map.put("msg", "账号或密码错误");
            }
        }else {
            map.put("msg", "账号或密码错误");
        }
        return map;
    }
}
