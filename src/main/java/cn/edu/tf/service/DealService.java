package cn.edu.tf.service;

import cn.edu.tf.pojo.Deal;
import com.github.pagehelper.PageInfo;

public interface DealService {
    PageInfo<Deal> myDeal(Long userId, Integer page, Integer limit);

    String add(Deal deal);

    String complete(Integer id);

    String cancel(Integer id);

    PageInfo<Deal> list(Deal deal, Integer page, Integer limit);
}
