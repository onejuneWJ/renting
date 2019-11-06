package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.*;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.*;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    public HouseController(HouseDao houseDao, TowardsDao towardsDao, RentalIncludeDao rentalIncludeDao, PaymentDao paymentDao, HouseIncludeDao houseIncludeDao, HouseService houseService, RequiresDao requiresDao, LocationDao locationDao) {
        this.houseDao = houseDao;
        this.towardsDao = towardsDao;
        this.rentalIncludeDao = rentalIncludeDao;
        this.paymentDao = paymentDao;
        this.houseIncludeDao = houseIncludeDao;
        this.houseService = houseService;
        this.requiresDao = requiresDao;
        this.locationDao = locationDao;
    }

    /**
     * 查询城市所有房源
     */
    @GetMapping("/")
    public String cityHouse(HttpSession session) {
        session.setAttribute("CURRENT_LOCATION", null);
        //从session中查询当前城市
        City city = (City)session.getAttribute("city");
        int cityId = city != null ? city.getId() : 1;

        return "index";
    }

    /**
     * 查询区域内房源
     *
     * @param cityId     城市id
     * @param locationId 区域id
     */
    @GetMapping("/{cityId}/{locationId}")
    public String locationHouse(@PathVariable int cityId, @PathVariable int locationId, HttpSession session) {
        Location location = locationDao.selectByPrimaryKey(locationId);
        session.setAttribute("CURRENT_LOCATION", location);
        return "index";
    }

    /**
     * 根据条件查询房源
     *
     * @param zj         租金范围
     */
    @GetMapping("/zj{zj}")
    public String house(@PathVariable int zj, HttpSession session) {
        if (zj == -1) {
            // 查询所有租金范围
            session.setAttribute("CURRENT_RENTAL", null);
        } else {
            String r = Constant.RENTAL_KEY_LIST.get(zj);
            session.setAttribute("CURRENT_RENTAL", r);
        }
        return "index";
    }

    /**
     * 添加房源
     *
     * @param body 房源信息
     * @return 返回添加成功提示信息
     */
    @PostMapping()
    @ResponseBody
    public String addHouse(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        JSONArray rentalIncludes = jsonObject.getJSONArray("rentalInclude");
        StringUtil.arrayToString((String[])rentalIncludes.toList().toArray());
        return body;
    }

    /**
     * 获取房屋朝向
     *
     * @return 所有房屋朝向
     */
    @GetMapping("/towards")
    @ResponseBody
    public ResponseData<Towards> getTowards() {
        ResponseData<Towards> responseData = new ResponseData<>();
        List<Towards> towardsList = towardsDao.selectByExample(null);
        responseData.setData(towardsList);
        return responseData;
    }

    /**
     * 查询所有付款方式
     *
     * @return 付款方式
     */
    @GetMapping("/payment")
    @ResponseBody
    public ResponseData<Payment> getPayment() {
        ResponseData<Payment> responseData = new ResponseData<>();
        List<Payment> paymentList = paymentDao.selectByExample(null);
        responseData.setData(paymentList);
        return responseData;
    }

    /**
     * 查询所有租金包含的项
     *
     * @return 所有项
     */
    @GetMapping("/rentalInclude")
    @ResponseBody
    public ResponseData<RentalInclude> getRentalInclude() {
        ResponseData<RentalInclude> responseData = new ResponseData<>();
        List<RentalInclude> rentalIncludeList = rentalIncludeDao.selectByExample(null);
        responseData.setData(rentalIncludeList);
        return responseData;
    }

    /**
     * 查询所有房屋配置的项
     *
     * @return 所有房屋配置包含的项
     */
    @GetMapping("/houseInclude")
    @ResponseBody
    public ResponseData<HouseInclude> getHouseInclude() {
        ResponseData<HouseInclude> responseData = new ResponseData<>();
        List<HouseInclude> houseIncludeList = houseIncludeDao.selectByExample(null);
        responseData.setData(houseIncludeList);
        return responseData;
    }

    /**
     * 查询所有出租要求项
     *
     * @return 所有出租要求项
     */
    @GetMapping("/require")
    @ResponseBody
    public ResponseData<Requires> getRequire() {
        ResponseData<Requires> responseData = new ResponseData<>();
        List<Requires> requireList = requiresDao.selectByExample(null);
        responseData.setData(requireList);
        return responseData;
    }


}
