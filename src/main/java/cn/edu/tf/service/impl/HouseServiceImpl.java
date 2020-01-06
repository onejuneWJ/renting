package cn.edu.tf.service.impl;

import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.HouseIncludeDao;
import cn.edu.tf.dao.RentalIncludeDao;
import cn.edu.tf.dao.RequiresDao;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.pojo.*;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/10/10 14:30
 **/
@Service
public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao;
    private HouseIncludeDao houseIncludeDao;
    private RentalIncludeDao rentalIncludeDao;
    private RequiresDao requiresDao;

    public HouseServiceImpl(HouseDao houseDao, HouseIncludeDao houseIncludeDao, RentalIncludeDao rentalIncludeDao, RequiresDao requiresDao) {
        this.houseDao = houseDao;
        this.houseIncludeDao = houseIncludeDao;
        this.rentalIncludeDao = rentalIncludeDao;
        this.requiresDao = requiresDao;
    }

    @Override
    public String add(House house) {
        return "success";
    }

    @Override
    public List<HouseDTO> selectByCondition(int index, HttpSession session) {
        return null;
    }

    @Override
    public List<HouseDTO> selectByCity(int cityId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit, true);
        List<HouseDTO> houseList=houseDao.selectByCity(cityId);
        houseList.forEach((houseDTO)->{
            //房屋配置列表
            String[] houseIncludeIds= StringUtil.stringToArray(houseDTO.getHouseInclude());
            if(houseIncludeIds.length>0){
                List<Integer> houseIncludeIdList=new ArrayList<>();
                for (String houseIncludeId : houseIncludeIds) {
                    int id=Integer.valueOf(houseIncludeId);
                    houseIncludeIdList.add(id);
                }
                HouseIncludeExample houseIncludeExample=new HouseIncludeExample();
                houseIncludeExample.createCriteria().andIdIn(houseIncludeIdList);
                List<HouseInclude> houseIncludeList=houseIncludeDao.selectByExample(houseIncludeExample);
                houseIncludeExample.clear();
                houseDTO.setHouseIncludeList(houseIncludeList);
            }
            //租金包含列表
            String[] rentalIncludeIds =StringUtil.stringToArray(houseDTO.getRentalInclude());
            if(rentalIncludeIds.length>0){
                List<Integer> rentalIncludeIdList=new ArrayList<>();
                for (String rentalIncludeId : rentalIncludeIds) {
                    rentalIncludeIdList.add(Integer.valueOf(rentalIncludeId));
                }
                RentalIncludeExample rentalIncludeExample=new RentalIncludeExample();
                rentalIncludeExample.createCriteria().andIdIn(rentalIncludeIdList);
                List<RentalInclude> rentalIncludeList=rentalIncludeDao.selectByExample(rentalIncludeExample);
                rentalIncludeExample.clear();
                houseDTO.setRentalIncludeList(rentalIncludeList);
            }
            //要求列表
            String[] requireIds=StringUtil.stringToArray(houseDTO.getRequire());
            if(requireIds.length>0){
                List<Integer> requireIdList=new ArrayList<>();
                for (String requireId : requireIds) {
                    requireIdList.add(Integer.valueOf(requireId));
                }
                RequiresExample requiresExample=new RequiresExample();
                requiresExample.createCriteria().andIdIn(requireIdList);
                List<Requires> requiresList=requiresDao.selectByExample(requiresExample);
                requiresExample.clear();
                houseDTO.setRequiresList(requiresList);
            }
        });
        return houseList;
    }
}
