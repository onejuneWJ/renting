package cn.edu.tf.service.impl;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.DealDao;
import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.pojo.Deal;
import cn.edu.tf.pojo.DealExample;
import cn.edu.tf.pojo.House;
import cn.edu.tf.service.DealService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {
    @Autowired
    private DealDao dealDao;
    @Autowired
    private HouseDao houseDao;

    @Override
    public PageInfo<Deal> list(Deal deal, Integer page, Integer limit) {
        return PageHelper.startPage(page,limit,true).doSelectPageInfo(()->dealDao.list(deal));
    }

    @Override
    public PageInfo<Deal> myDeal(Long userId, Integer page, Integer limit) {
        return PageHelper.startPage(page,limit,true).doSelectPageInfo(()->dealDao.myDeal(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String add(Deal deal) {
        DealExample dealExample=new DealExample();
        dealExample.createCriteria().andHouseIdEqualTo(deal.getHouseId()).andRenterIdEqualTo(deal.getRenterId()).andLeaserIdEqualTo(deal.getLeaserId());
        List<Deal> list = dealDao.selectByExample(dealExample);
        if(list.size()>0){
            return "不能重复创建交易";
        }
        deal.setCreateTime(new Date());
        dealDao.insertSelective(deal);
        House house=new House();
        house.setId(deal.getHouseId());
        house.setStatus(Constant.houseStatus.Y);
        houseDao.updateByPrimaryKeySelective(house);
        return Constant.SUCCESS;
    }

    @Override
    public String complete(Integer id) {
        Deal deal=new Deal();
        deal.setId(id);
        deal.setStatus(Constant.dealStatus.SUCCESS);
        deal.setCompleteTime(new Date());
        dealDao.updateByPrimaryKeySelective(deal);
        return Constant.SUCCESS;
    }

    @Override
    public String cancel(Integer id) {
        Deal deal=new Deal();
        deal.setId(id);
        deal.setStatus(Constant.dealStatus.FAILED);
        dealDao.updateByPrimaryKeySelective(deal);
        return Constant.SUCCESS;
    }

}
