package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.*;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.dto.PageRequest;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.*;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.service.ImgService;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author : 王俊
 * @date : 2019/9/17 17:56
 **/
@RequestMapping("/house")
@Controller
public class HouseController {

    private HouseDao houseDao;
    private TowardsDao towardsDao;
    private RentalIncludeDao rentalIncludeDao;
    private PaymentDao paymentDao;
    private HouseIncludeDao houseIncludeDao;
    private HouseService houseService;
    private RequiresDao requiresDao;
    private LocationDao locationDao;
    private ImgService imgService;
    private CityDao cityDao;

    public HouseController(HouseDao houseDao, TowardsDao towardsDao, RentalIncludeDao rentalIncludeDao, PaymentDao paymentDao, HouseIncludeDao houseIncludeDao, HouseService houseService, RequiresDao requiresDao, LocationDao locationDao, ImgService imgService, CityDao cityDao) {
        this.houseDao = houseDao;
        this.towardsDao = towardsDao;
        this.rentalIncludeDao = rentalIncludeDao;
        this.paymentDao = paymentDao;
        this.houseIncludeDao = houseIncludeDao;
        this.houseService = houseService;
        this.requiresDao = requiresDao;
        this.locationDao = locationDao;
        this.imgService = imgService;
        this.cityDao = cityDao;
    }

    /**
     * 查询当前城市所有房源
     */
    @GetMapping
    public String cityHouse(HttpSession session) {
        //清空session中的区域信息
        session.setAttribute("CURRENT_LOCATION", null);
        return "redirect:index.htm";
    }

    /**
     * 选择城市
     */
    @GetMapping("/{cityId}")
    public String otherCity(@PathVariable int cityId, HttpSession session) {
        City city = cityDao.selectByPrimaryKey(cityId);
        session.setAttribute("CITY", city);
        //清空session中的区域信息
        session.setAttribute("CURRENT_LOCATION", null);
        return "redirect:../index.htm";
    }

    /**
     * 查询区域内房源
     *
     * @param cityId     城市id
     * @param locationId 区域id
     */
    @GetMapping("/{cityId}/{locationId}")
    public String locationHouse(@PathVariable int cityId, @PathVariable int locationId,
                                HttpSession session, Model model, PageRequest pageRequest,
                                String rentalSort, String timeSort, String sortFlag) {

        session.setAttribute("CURRENT_RENTAL", null);
        session.setAttribute("CURRENT_HOUSE_TYPE", null);
        session.setAttribute("CURRENT_TOWARDS", null);
        if (!StringUtils.isEmpty(rentalSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("rental");
            sort.setDirection(rentalSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("rentalSort", rentalSort);
        } else {
            model.addAttribute("rentalSort", null);
        }
        if (!StringUtils.isEmpty(timeSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("post_time");
            sort.setDirection(timeSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("timeSort", timeSort);
        } else {
            model.addAttribute("timeSort", null);
        }
        Location location = locationDao.selectByPrimaryKey(locationId);
        session.setAttribute("CURRENT_LOCATION", location);
        Page<HouseDTO> houseList = houseService.selectByLocation(locationId, pageRequest);
        model.addAttribute("houseList", houseList);
        model.addAttribute("count", houseList.getTotal());
        model.addAttribute("page", pageRequest.getPage());
        model.addAttribute("limit", pageRequest.getLimit());
        model.addAttribute("sortFlag", sortFlag);

        return "index";
    }

    /**
     * 根据租金条件查询房源
     *
     * @param index 租金范围
     */
    @GetMapping("/zj{index}")
    public String houseWithZj(@PathVariable int index, HttpSession session,
                              Model model, PageRequest pageRequest,
                              String rentalSort, String timeSort, String sortFlag) {
        if (!StringUtils.isEmpty(rentalSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("rental");
            sort.setDirection(rentalSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("rentalSort", rentalSort);
        } else {
            model.addAttribute("rentalSort", null);
        }
        if (!StringUtils.isEmpty(timeSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("post_time");
            sort.setDirection(timeSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("timeSort", timeSort);
        } else {
            model.addAttribute("timeSort", null);
        }
        if (index == -1) {
            //清空session
            session.setAttribute("CURRENT_RENTAL", null);
        } else {
            Constant.Rentals r = Constant.Rentals.values()[index];
            session.setAttribute("CURRENT_RENTAL", r);
        }
        Page<HouseDTO> houseList = houseService.selectByCondition(session, pageRequest);
        model.addAttribute("houseList", houseList);
        model.addAttribute("count", houseList.getTotal());
        model.addAttribute("page", pageRequest.getPage());
        model.addAttribute("limit", pageRequest.getLimit());
        model.addAttribute("sortFlag", sortFlag);
        return "index";
    }

    /**
     * 根据房型条件查询房源，室的数量
     *
     * @param index 房型范围
     */
    @GetMapping("/fx{index}")
    public String houseWithFx(@PathVariable int index, HttpSession session,
                              Model model, PageRequest pageRequest,
                              String rentalSort, String timeSort, String sortFlag) {
        if (!StringUtils.isEmpty(rentalSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("rental");
            sort.setDirection(rentalSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("rentalSort", rentalSort);
        } else {
            model.addAttribute("rentalSort", null);
        }
        if (!StringUtils.isEmpty(timeSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("post_time");
            sort.setDirection(timeSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("timeSort", timeSort);
        } else {
            model.addAttribute("timeSort", null);
        }
        if (index == -1) {
            // 查询所有房型范围的房源
            //清空session
            session.setAttribute("CURRENT_HOUSE_TYPE", null);
        } else {
            Constant.HouseType f = Constant.HouseType.values()[index];
            session.setAttribute("CURRENT_HOUSE_TYPE", f);
        }
        Page<HouseDTO> houseList = houseService.selectByCondition(session, pageRequest);
        model.addAttribute("houseList", houseList);
        model.addAttribute("count", houseList.getTotal());
        model.addAttribute("page", pageRequest.getPage());
        model.addAttribute("limit", pageRequest.getLimit());
        model.addAttribute("sortFlag", sortFlag);
        return "index";
    }

    /**
     * 根据朝向查询房源
     */
    @GetMapping("/tw{index}")
    public String houseWithTw(@PathVariable int index, HttpSession session,
                              Model model, PageRequest pageRequest,
                              String rentalSort, String timeSort, String sortFlag) {
        if (!StringUtils.isEmpty(rentalSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("rental");
            sort.setDirection(rentalSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("rentalSort", rentalSort);
        } else {
            model.addAttribute("rentalSort", null);
        }
        if (!StringUtils.isEmpty(timeSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("post_time");
            sort.setDirection(timeSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("timeSort", timeSort);
        } else {
            model.addAttribute("timeSort", null);
        }
        if (index == -1) {
            // 查询所有朝向范围
            session.setAttribute("CURRENT_TOWARDS", null);
        } else {
            Towards towards = towardsDao.selectByExample(null).get(index);
            session.setAttribute("CURRENT_TOWARDS", towards);
        }
        Page<HouseDTO> houseList = houseService.selectByCondition(session, pageRequest);
        model.addAttribute("houseList", houseList);
        model.addAttribute("count", houseList.getTotal());
        model.addAttribute("page", pageRequest.getPage());
        model.addAttribute("limit", pageRequest.getLimit());
        model.addAttribute("sortFlag", sortFlag);
        return "index";
    }

    @GetMapping("/to/{houseId}")
    public String detail(@PathVariable Integer houseId, Model model) {
        HouseDTO house = houseService.selectById(houseId);
        model.addAttribute("house", house);
        return "house";
    }

    /**
     * 添加房源
     *
     * @param body 房源信息
     * @return 返回添加成功提示信息
     */
    @PostMapping()
    @ResponseBody
    public ResponseData<?> addHouse(@RequestBody String body, HttpSession session) {
        User user = (User) session.getAttribute("CURRENT_USER");
        if (null == user) {
            return new ResponseData<>(ResponseData.CODE_ERROR, "请先登录再发布房源", null);
        }
        JSONObject jsonObject = new JSONObject(body);
        House house = new House();
        house.setUserId(user.getId());
        house.setPlotId(jsonObject.getLong("plotId"));
        house.setHuxingShi(jsonObject.getInt("huxingShi"));
        house.setHuxingTing(jsonObject.getInt("huxingTing"));
        house.setHuxingWei(jsonObject.getInt("huxingWei"));
        house.setArea(jsonObject.getInt("area"));
        house.setCurrentFloor(jsonObject.getInt("currentFloor"));
        house.setTotalFloor(jsonObject.getInt("totalFloor"));
        house.setRental(jsonObject.getDouble("rental"));
        house.setRentalInclude(jsonObject.getJSONArray("rentalInclude").toList().toString());
        house.setHouseInclude(jsonObject.getJSONArray("houseInclude").toList().toString());
        house.setRequire(jsonObject.getJSONArray("require").toList().toString());
        house.setPaymentId(jsonObject.getInt("paymentId"));
        house.setTowardsId(jsonObject.getInt("towardsId"));
        house.setDescription(jsonObject.getString("description"));

        Long imgBoxId = (Long) session.getAttribute("IMG_BOX_ID");
        if (Objects.isNull(imgBoxId)) {
            return new ResponseData<>(ResponseData.CODE_ERROR, "请上传至少一张房屋图片", null);
        }
        house.setImgBoxId(imgBoxId);
        house.setPostTime(new Date());
        houseDao.insertSelective(house);
        session.setAttribute("IMG_BOX_ID", null);
        return ResponseData.ok(house, Constant.SUCCESS);
    }

    /**
     * 获取房屋朝向
     *
     * @return 所有房屋朝向
     */
    @GetMapping("/towards")
    @ResponseBody
    public ResponseData<List<Towards>> getTowards() {
        return ResponseData.ok(towardsDao.selectByExample(null));
    }

    /**
     * 查询所有付款方式
     *
     * @return 付款方式
     */
    @GetMapping("/payment")
    @ResponseBody
    public ResponseData<List<Payment>> getPayment() {
        return ResponseData.ok(paymentDao.selectByExample(null));
    }

    /**
     * 查询所有租金包含的项
     *
     * @return 所有项
     */
    @GetMapping("/rentalInclude")
    @ResponseBody
    public ResponseData<List<RentalInclude>> getRentalInclude() {
        return ResponseData.ok(rentalIncludeDao.selectByExample(null));
    }

    /**
     * 查询所有房屋配置的项
     *
     * @return 所有房屋配置包含的项
     */
    @GetMapping("/houseInclude")
    @ResponseBody
    public ResponseData<List<HouseInclude>> getHouseInclude() {
        return ResponseData.ok(houseIncludeDao.selectByExample(null));
    }

    /**
     * 查询所有出租要求项
     *
     * @return 所有出租要求项
     */
    @GetMapping("/require")
    @ResponseBody
    public ResponseData<List<Requires>> getRequire() {
        return ResponseData.ok(requiresDao.selectByExample(null));
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseData<?> upload(@RequestParam("img") MultipartFile multipartFile, HttpSession session) {
        if (multipartFile.isEmpty()) {
            return new ResponseData<>(ResponseData.CODE_ERROR, "文件不存在", null);
        }
        String fileName = multipartFile.getOriginalFilename();
        String path = "D:/MyFile/uploadFiles/" + fileName;
        File file = new File(path);
        Img img = new Img();
        try {
            multipartFile.transferTo(file);
            img.setUrl(path);
            img.setImgName(fileName);
            img = imgService.createImg(img, session);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.CODE_ERROR, "上传文件失败", null);
        }
        return ResponseData.ok(img);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseData<?> delete(@PathVariable Long id) {
        return ResponseData.ok(null, houseService.delete(id));
    }

    @GetMapping("admin/list")
    @ResponseBody
    public ResponseData<List<HouseDTO>> listForAdmin(House house,PageRequest pageRequest){
        return ResponseData.pageOk(houseService.listForAdmin(house,pageRequest));
    }
}
