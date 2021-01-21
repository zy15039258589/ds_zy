package com.fh.service;

import com.fh.entity.po.Goods;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;

public interface GoodsService {
    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(Integer id);

    PageResult selectGoods(BrandParams params);

    void addGoodsOrProper(Goods goods, String noSku, String sku);
}
