package cn.edu.tf.service.impl;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.VisitDao;
import cn.edu.tf.pojo.Visit;
import cn.edu.tf.service.VisitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitDao visitDao;

    @Override
    public PageInfo<Visit> list(Long userId, Integer page, Integer limit) {
        return PageHelper.startPage(page, limit, true).doSelectPageInfo(() -> visitDao.list(userId));
    }

    @Override
    public String delete(Long id) {
        visitDao.deleteByPrimaryKey(id);
        return Constant.SUCCESS;
    }
}
