package cn.edu.tf.controller;

import cn.edu.tf.dao.VisitDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.User;
import cn.edu.tf.pojo.Visit;
import cn.edu.tf.pojo.VisitExample;
import cn.edu.tf.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2020/1/10 15:24
 **/
@Controller
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitDao visitDao;
    @Autowired
    private VisitService visitService;
    @PostMapping
    @ResponseBody
    public ResponseData<?> see(HttpSession session, Long houseId) {
        User user = (User)session.getAttribute("CURRENT_USER");
        System.out.println(houseId);
        if (user == null) {
            return ResponseData.ok(null, "请先登录，再发起看房请求噢");
        }
        VisitExample visitExample = new VisitExample();
        visitExample.createCriteria()
            .andUserIdEqualTo(user.getId())
            .andHouseIdEqualTo(houseId);
        List<Visit> visitList = visitDao.selectByExample(visitExample);
        if (visitList.size() > 0) {
            return ResponseData.ok(null, "您已发起过看房请求了，请耐心等待房东的回复，或者直接联系房东噢");
        }
        Visit visit = new Visit();
        visit.setUserId(user.getId());
        visit.setHouseId(houseId);
        visit.setRequestTime(new Date());
        visitDao.insertSelective(visit);
        return ResponseData.ok(houseId, "success");
    }

    @GetMapping
    @ResponseBody
    public ResponseData<List<Visit>> list(Long userId, Integer page, Integer limit){
        return ResponseData.pageOk(visitService.list(userId, page, limit));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseData<?> delete(@PathVariable Long id){
        return ResponseData.ok(null,visitService.delete(id));
    }
}
