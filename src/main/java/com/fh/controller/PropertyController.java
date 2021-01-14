package com.fh.controller;

import com.fh.entity.po.Property;
import com.fh.entity.vo.PageResult;
import com.fh.entity.vo.PropertyParams;
import com.fh.entity.vo.ResultData;
import com.fh.service.PropertyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("PropertyController")
@CrossOrigin
public class PropertyController {
    @Resource
    PropertyService propertyService;

    /*
    接口：分页 查询所有的属性数据
    * 请求：post请求
    * 参数 page 当前页（必传） ,limit 每页显示条数（必传）,name 条件查询
    * 返回值   {"code":0,count="总条数",data:[{*}]}
    *路径：http://192.168.235.1:8080/PropertyController/getDate
    * */
    @PostMapping("getDate")
    public PageResult getDate(PropertyParams params){
        PageResult result=propertyService.getData(params);
        return result;
    }
    @PostMapping("add")
    public ResultData add(Property property){
        propertyService.add(property);
        return ResultData.success(null);
    }
    @PostMapping("update")
    public ResultData update(Property property){
        if(property.getId()==null){
            return ResultData.error(500,"没传id");
        }else{
            propertyService.update(property);
            return ResultData.success(null);
        }
    }



}
