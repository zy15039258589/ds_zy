package com.fh.service.impl;

import com.fh.dao.ValueDao;
import com.fh.entity.po.Property;
import com.fh.entity.po.Value;
import com.fh.service.ValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValueServiceImpl implements ValueService {
    @Resource
    ValueDao valueDao;



    @Override
    public List<Value> getData(Integer propertyId) {
        List<Value> list=valueDao.getData(propertyId);
        return list;
    }

    @Override
    public void add(Value value) {
        valueDao.add(value);
    }

    @Override
    public void update(Value value) {
        valueDao.update(value);
    }

    @Override
    public void delete(Integer id) {
        valueDao.delete(id);
    }

    @Override
    public Map queryByTypeId(Integer typeId) {
        //List values=new ArrayList();
        //先通过分类id查询出对应的所有属性
        Map map=new HashMap();
        List<Object> sku= new ArrayList();
        List noSku= new ArrayList();
        List<Property> list=valueDao.queryByTypeId(typeId);
        for (int i = 0; i <list.size() ; i++) {
            //判断不是文本框的时候在通过属性id查询出属性对应的值
            if(list.get(i).getIsSKU()==0){
                Property property=new Property();
                property=list.get(i);
                List ckvalue=new ArrayList();
                property.setCkvalue(ckvalue);
                List<Value>  values = valueDao.getData(list.get(i).getId());
                property.setValues(values);
                sku.add(property);
            }
            if(list.get(i).getIsSKU()==1){
                //获取值数据
                List<Value>  values= valueDao.getData(list.get(i).getId());
                //声明一个对象
                Property property=new Property();
                //给对象赋值
                property=list.get(i);
                //创建一个空的集合
                List ckvalue=new ArrayList();
                //给定义的属性赋一个空数组
                property.setCkvalue(ckvalue);
                property.setValues(values);
                noSku.add(property);
            }
        }
        map.put("skuData",sku);
        map.put("attrData",noSku);
        return map;
    }
}