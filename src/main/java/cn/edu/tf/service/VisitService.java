package cn.edu.tf.service;

import cn.edu.tf.pojo.Visit;
import com.github.pagehelper.PageInfo;

public interface VisitService {
    PageInfo<Visit> list(Long userId, Integer page, Integer limit);

    String delete(Long id);
}
