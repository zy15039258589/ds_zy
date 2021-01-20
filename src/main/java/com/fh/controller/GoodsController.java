package com.fh.controller;

import com.fh.entity.po.Goods;
import com.fh.entity.vo.ResultData;
import com.fh.service.GoodsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
