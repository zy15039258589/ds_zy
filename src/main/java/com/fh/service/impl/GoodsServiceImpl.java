package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.dao.GoodsDao;
import com.fh.entity.po.Goods;
import com.fh.entity.po.GoodsProperty;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;
import com.fh.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    @Transactional  //加上事务   什么是事务
    public void addGoodsOrProper(Goods goods, String noSku, String sku) {
        goods.setCreateDate(new Date());
        goodsDao.addGoods(goods);
        List<GoodsProperty> gpList=new ArrayList<>();
        //处理非sku数据
        JSONArray noSkuArr = JSONObject.parseArray(noSku);
        for (int i = 0; i <noSkuArr.size() ; i++) {
            //构建属性数据对象
            GoodsProperty gp=new GoodsProperty();
            //设置对应的商品id
            gp.setProId(goods.getId());
            //处理传过来的json对象数据
            gp.setAttrData(noSkuArr.get(i).toString());
            gpList.add(gp);
        }
        JSONArray skuArr = JSONObject.parseArray(sku);
        for (int i = 0; i <skuArr.size() ; i++) {
            JSONObject dataJs= (JSONObject) skuArr.get(i);
            //构建属性数据对象
            GoodsProperty gp2=new GoodsProperty();
            //设置对应的商品id
            gp2.setProId(goods.getId());
            //根据key获取value值
            gp2.setPrice(dataJs.getDouble("price"));
            gp2.setStorcks(dataJs.getInteger("stocks"));
            //先把价格和库存取出来删了在新增数据
            dataJs.remove("price");
            dataJs.remove("stocks");
            //新增数据
            gp2.setAttrData(skuArr.get(i).toString());
            gpList.add(gp2);
        }
        goodsDao.addGoodsOrProper(gpList);
    }

    @Override
    public List<GoodsProperty> queryByProId(Integer proId) {
        List<GoodsProperty> list=goodsDao.queryByProId(proId);
        return list;
    }

    @Override
    @Transactional  //加上事务   什么是事务
    public void updateGoodsOrProper(GoodsProperty goodsProperty) {
            //先把之前的删除
        goodsDao.deleteGoodsOrProper(goodsProperty);
        //goodsDao.
    }

    @Override
    public Map huixianGoodsProperty(Integer proId) {

        return null;
    }
}
