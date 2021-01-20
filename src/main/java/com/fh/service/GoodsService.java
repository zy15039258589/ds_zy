package com.fh.service;

import com.fh.entity.po.Goods;

public interface GoodsService {
    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(Integer id);
}
