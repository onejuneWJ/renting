package cn.edu.tf.controller;

import cn.edu.tf.dao.ProvinceDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceDao provinceDao;

    @GetMapping
    public ResponseData<List<Province>> list(Province province) {

        return ResponseData.ok(provinceDao.selectByExample(null));
    }
}
