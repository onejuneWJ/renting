package cn.edu.tf.controller;

import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.Deal;
import cn.edu.tf.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private DealService dealService;

    @GetMapping
    public ResponseData<List<Deal>> list(Deal deal, Integer page, Integer limit){
        return ResponseData.pageOk(dealService.list(deal,page,limit));
    }

    @PostMapping
    public ResponseData<?> create(@RequestBody Deal deal){
        return ResponseData.ok(null,dealService.add(deal));
    }

    @DeleteMapping
    public ResponseData<?> delete(){
        return ResponseData.ok(null,"");
    }

    @PutMapping("/complete/{id}")
    public ResponseData<?> complete(@PathVariable Integer id){
        return ResponseData.ok(null, dealService.complete(id));
    }

    @PutMapping("/cancel/{id}")
    public ResponseData<?> cancel(@PathVariable Integer id){
        return ResponseData.ok(null, dealService.cancel(id));
    }
}
