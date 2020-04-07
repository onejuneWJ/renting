package cn.edu.tf.service.impl;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.*;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.dto.PageRequest;
import cn.edu.tf.pojo.*;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.utils.StringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private ImgDao imgDao;

    public HouseServiceImpl(HouseDao houseDao, HouseIncludeDao houseIncludeDao, RentalIncludeDao rentalIncludeDao, RequiresDao requiresDao, ImgDao imgDao) {
        this.houseDao = houseDao;
        this.houseIncludeDao = houseIncludeDao;
        this.rentalIncludeDao = rentalIncludeDao;
        this.requiresDao = requiresDao;
        this.imgDao = imgDao;
    }

    @Override
    public String add(House house) {
        return "success";
    }

    @Override
    public Page<HouseDTO> selectByCondition(HttpSession session, PageRequest pageRequest) {
        Location location = (Location)session.getAttribute("CURRENT_LOCATION");
        City city = (City)session.getAttribute("CITY");
        Constant.Rentals rentals = (Constant.Rentals)session.getAttribute("CURRENT_RENTAL");
        Constant.HouseType houseType = (Constant.HouseType)session.getAttribute("CURRENT_HOUSE_TYPE");
        Towards towards = (Towards)session.getAttribute("CURRENT_TOWARDS");
        StringBuilder orderBy = new StringBuilder();
        pageRequest.getSortList().forEach((sort -> orderBy.append(sort.getClause()).append(" ").append(sort.getDirection()).append(",")));
        if (orderBy.lastIndexOf(",") > 0) {
            orderBy.deleteCharAt(orderBy.lastIndexOf(","));
        }
        PageHelper.orderBy(orderBy.toString());
        Page<HouseDTO> pageInfo = PageHelper.startPage(
            ObjectUtils.defaultIfNull(pageRequest.getPage(), 1),
            ObjectUtils.defaultIfNull(pageRequest.getLimit(), 20), true);
        houseDao.selectByCondition(city, location, rentals, houseType, towards);

        List<HouseDTO> houseList = pageInfo.getResult();
        houseList.forEach(this::loadHouseInfo);
        return pageInfo;
    }

    @Override
    public Page<HouseDTO> selectByCity(int cityId, PageRequest pageRequest) {
        StringBuilder orderBy = new StringBuilder();
        pageRequest.getSortList().forEach((sort -> orderBy.append(sort.getClause()).append(" ").append(sort.getDirection()).append(",")));
        if (orderBy.lastIndexOf(",") > 0) {
            orderBy.deleteCharAt(orderBy.lastIndexOf(","));
        }
        PageHelper.orderBy(orderBy.toString());
        Page<HouseDTO> pageInfo = PageHelper.startPage(
            ObjectUtils.defaultIfNull(pageRequest.getPage(), 1),
            ObjectUtils.defaultIfNull(pageRequest.getLimit(), 20), true);
        houseDao.selectByCity(cityId);
        List<HouseDTO> houseList = pageInfo.getResult();
        houseList.forEach(this::loadHouseInfo);
        return pageInfo;
    }

    @Override
    public Page<HouseDTO> selectByLocation(int locationId, PageRequest pageRequest) {
        StringBuilder orderBy;
        orderBy = new StringBuilder();
        pageRequest.getSortList().forEach((sort -> orderBy.append(sort.getClause()).append(" ").append(sort.getDirection()).append(",")));
        if (orderBy.lastIndexOf(",") > 0) {
            orderBy.deleteCharAt(orderBy.lastIndexOf(","));
        }
        PageHelper.orderBy(orderBy.toString());
        Page<HouseDTO> pageInfo = PageHelper.startPage(
            ObjectUtils.defaultIfNull(pageRequest.getPage(), 1),
            ObjectUtils.defaultIfNull(pageRequest.getLimit(), 20), true);
        houseDao.selectByLocation(locationId);
        List<HouseDTO> houseList = pageInfo.getResult();
        houseList.forEach(this::loadHouseInfo);
        return pageInfo;
    }

    @Override
    public HouseDTO selectById(Integer houseId) {
        HouseDTO houseDTO=houseDao.selectById(houseId);
        loadHouseInfo(houseDTO);
        return houseDTO;
    }

    @Override
    public PageInfo<HouseDTO> myPost(Long userId, Integer page, Integer limit) {
        return PageHelper.startPage(page,limit,true).doSelectPageInfo(()->{
            houseDao.myPost(userId);
        });
    }

    @Override
    public String delete(Long id) {
        House house=houseDao.selectByPrimaryKey(id);
        String status=house.getStatus();
        if(Constant.houseStatus.Y.equals(status)){
            return "房源在租中，无法删除";
        }
        houseDao.deleteByPrimaryKey(id);
        return Constant.SUCCESS;
    }

    @Override
    public PageInfo<HouseDTO> listForAdmin(House house, PageRequest pageRequest) {
        return PageHelper.startPage(pageRequest.getPage(),pageRequest.getLimit()).doSelectPageInfo(()->{
            houseDao.listForAdmin(house);
        });
    }

    private void loadHouseInfo(HouseDTO houseDTO) {
        if (Objects.isNull(houseDTO)) {
            return;
        }
        //房屋配置列表
        String[] houseIncludeIds = StringUtil.stringToArray(houseDTO.getHouseInclude());
        if (houseIncludeIds.length > 0) {
            List<Integer> houseIncludeIdList = new ArrayList<>();
            for (String houseIncludeId : houseIncludeIds) {
                int id = Integer.valueOf(houseIncludeId);
                houseIncludeIdList.add(id);
            }
            HouseIncludeExample houseIncludeExample = new HouseIncludeExample();
            houseIncludeExample.createCriteria().andIdIn(houseIncludeIdList);
            List<HouseInclude> houseIncludeList = houseIncludeDao.selectByExample(houseIncludeExample);
            houseIncludeExample.clear();
            houseDTO.setHouseIncludeList(houseIncludeList);
        }
        //租金包含列表
        String[] rentalIncludeIds = StringUtil.stringToArray(houseDTO.getRentalInclude());
        if (rentalIncludeIds.length > 0) {
            List<Integer> rentalIncludeIdList = new ArrayList<>();
            for (String rentalIncludeId : rentalIncludeIds) {
                rentalIncludeIdList.add(Integer.valueOf(rentalIncludeId));
            }
            RentalIncludeExample rentalIncludeExample = new RentalIncludeExample();
            rentalIncludeExample.createCriteria().andIdIn(rentalIncludeIdList);
            List<RentalInclude> rentalIncludeList = rentalIncludeDao.selectByExample(rentalIncludeExample);
            rentalIncludeExample.clear();
            houseDTO.setRentalIncludeList(rentalIncludeList);
        }
        //要求列表
        String[] requireIds = StringUtil.stringToArray(houseDTO.getRequire());
        if (requireIds.length > 0) {
            List<Integer> requireIdList = new ArrayList<>();
            for (String requireId : requireIds) {
                requireIdList.add(Integer.valueOf(requireId));
            }
            RequiresExample requiresExample = new RequiresExample();
            requiresExample.createCriteria().andIdIn(requireIdList);
            List<Requires> requiresList = requiresDao.selectByExample(requiresExample);
            requiresExample.clear();
            houseDTO.setRequiresList(requiresList);
        }
        // 图片列表
        ImgExample imgExample = new ImgExample();
        imgExample.createCriteria().andBoxIdEqualTo(houseDTO.getImgBoxId());
        List<Img> imgList = imgDao.selectByExample(imgExample);
        imgExample.clear();
        houseDTO.setImgList(imgList);

    }
}
