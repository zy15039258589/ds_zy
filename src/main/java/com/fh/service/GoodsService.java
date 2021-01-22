package com.fh.service;

import com.fh.entity.po.Goods;
import com.fh.entity.po.GoodsProperty;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;

import java.util.List;

public interface GoodsService {
    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(Integer id);

    PageResult selectGoods(BrandParams params);

    void addGoodsOrProper(Goods goods, String noSku, String sku);

    List<GoodsProperty> queryByProId(Integer proId);
}
