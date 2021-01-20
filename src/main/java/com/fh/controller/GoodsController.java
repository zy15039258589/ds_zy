package com.fh.controller;

import com.fh.entity.po.Goods;
import com.fh.entity.vo.ResultData;
import com.fh.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@RequestMapping("GoodsController")
@CrossOrigin
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @PostMapping("addGoods")
    public ResultData addGoods(Goods goods){
        goodsService.addGoods(goods);
        return ResultData.success(null);
    }

    @PostMapping("updateGoods")
    public ResultData updateGoods(Goods goods){
        if(goods.getId()==null){
            return ResultData.error(500,"传值错误");
        }
        goodsService.updateGoods(goods);
        return ResultData.success(null);
    }
    @GetMapping("deleteGoods")
    public ResultData deleteGoods(Integer id){
        if(id==null){
            return ResultData.error(500,"传值错误");
        }
        goodsService.deleteGoods(id);
        return  ResultData.success(null);
    }

}
