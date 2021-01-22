package com.fh.controller;

import com.fh.entity.po.Goods;
import com.fh.entity.po.GoodsProperty;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;
import com.fh.entity.vo.ResultData;
import com.fh.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("selectGoods")
    public PageResult  selectGoods(BrandParams params){
        PageResult result=goodsService.selectGoods(params);
        return result;
    }

    @PostMapping("addGoodsOrProper")
    public ResultData addGoodsOrProper(Goods goods,String noSku,String sku){
        goodsService.addGoodsOrProper(goods,noSku,sku);
        return ResultData.success(null);
    }
    @GetMapping("queryByProId")
    public ResultData queryByProId(Integer proId){
        List<GoodsProperty> list =goodsService.queryByProId(proId);
        return ResultData.success(list);
    }
}
