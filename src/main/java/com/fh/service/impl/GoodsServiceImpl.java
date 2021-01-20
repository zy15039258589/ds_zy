package com.fh.service.impl;

import com.fh.dao.GoodsDao;
import com.fh.entity.po.Goods;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;
import com.fh.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsDao goodsDao;

    @Override
    public void addGoods(Goods goods) {
        goods.setCreateDate(new Date());
        goodsDao.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goods.setUpdateDate(new Date());
        goodsDao.updateGoods(goods);
    }

    @Override
    public void deleteGoods(Integer id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public PageResult selectGoods(BrandParams params) {
        Long count=goodsDao.selectGoodsCount(params);
        params.setStartIndex((params.getPage()-1)*params.getLimit());
        List<Goods> list =goodsDao.selectGoodsList(params);
        PageResult result=new PageResult();
        result.setCode(200);
        result.setData(list);
        result.setCount(count);
        return result;
    }
}
