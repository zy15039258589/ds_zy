package com.fh.controller;

import com.fh.entity.po.Goods;
import com.fh.entity.po.GoodsProperty;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;
import com.fh.entity.vo.ResultData;
import com.fh.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("GoodsController")
@CrossOrigin
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @PostMapping("addGoods")
    public ResultData addGoods(Goods goods) {
        goodsService.addGoods(goods);
        return ResultData.success(null);
    }

    @PostMapping("updateGoods")
    public ResultData updateGoods(Goods goods) {
        if (goods.getId() == null) {
            return ResultData.error(500, "传值错误");
        }
        goodsService.updateGoods(goods);
        return ResultData.success(null);
    }

    @GetMapping("deleteGoods")
    public ResultData deleteGoods(Integer id) {
        if (id == null) {
            return ResultData.error(500, "传值错误");
        }
        goodsService.deleteGoods(id);
        return ResultData.success(null);
    }

    @PostMapping("selectGoods")
    public PageResult selectGoods(BrandParams params) {
        PageResult result = goodsService.selectGoods(params);
        return result;
    }

    //新增商品属性
    @PostMapping("addGoodsOrProper")
    public ResultData addGoodsOrProper(Goods goods, String noSku, String sku) {
        goodsService.addGoodsOrProper(goods, noSku, sku);
        return ResultData.success(null);
    }

    //根据商品id查询所有的属性
    @GetMapping("queryByProId")
    public ResultData queryByProId(Integer proId) {
        List<GoodsProperty> list = goodsService.queryByProId(proId);
        return ResultData.success(list);
    }

    //商品属性的修改
    @GetMapping("updateGoodsOrProper")
    public ResultData updateGoodsOrProper(GoodsProperty goodsProperty) {
        goodsService.updateGoodsOrProper(goodsProperty);
        return ResultData.success(null);
    }

    //商品属性的回显
    public ResultData huixianGoodsProperty(Integer proId) {
        Map map = goodsService.huixianGoodsProperty(proId);
        return ResultData.success(map);
    }

}
