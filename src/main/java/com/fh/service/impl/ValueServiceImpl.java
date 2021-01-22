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
            if(list.get(i).getType()!=3 && list.get(i).getIsSKU()==0){
                 Map map2=new HashMap();
                map2.put("name",list.get(i).getName());
                map2.put("nameCH",list.get(i).getNameCH());
                map2.put("typeId",list.get(i).getTypeId());
                map2.put("type",list.get(i).getType());
                map2.put("isSKU",list.get(i).getIsSKU());
                map2.put("isDel",list.get(i).getIsDel());
                //所有的sku属性的属性值
                List<Value>  values = valueDao.getData(list.get(i).getId());
                map2.put("values",values);
                sku.add(map2);
            }
            if(list.get(i).getType()!=3 && list.get(i).getIsSKU()==1){
                Map map2=new HashMap();
                map2.put("name",list.get(i).getName());
                map2.put("nameCH",list.get(i).getNameCH());
                map2.put("typeId",list.get(i).getTypeId());
                map2.put("type",list.get(i).getType());
                map2.put("isSKU",list.get(i).getIsSKU());
                map2.put("isDel",list.get(i).getIsDel());
                List<Value>  values= valueDao.getData(list.get(i).getId());
                map2.put("values",values);
                noSku.add(map2);
            }
        }
        map.put("skuData",sku);
        map.put("attrData",noSku);
        return map;
    }
}