package com.fh.controller;

import com.fh.entity.po.Type;
import com.fh.entity.vo.ResultData;
import com.fh.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class TypeController {
    @Resource
    TypeService typeService;

    /*
    接口：查询所有的分类数据
    * 请求：get请求
    * 参数 无参
    * 返回值   {"code":200,"message":"提示",data:[{*}]}
    *路径：http://192.168.235.1:8080/api/type/getData
    * */
    @GetMapping("getData")
    public ResultData getData(){
        List<Type> list=typeService.getData();
        return ResultData.success(list);
    }






     /*
    接口：查询指定pid的数据
    * 请求：get请求
    * 参数 pid
    * 返回值   {"code":200,"message":"提示",data:[{*}]}
    *路径：http://192.168.235.1:8080/api/type/getDataByPid
    * */
    @GetMapping("getDataByPid")
    public ResultData  getDataByPid(Integer pid){
        List list=typeService.getDataByPid(pid);
        return  ResultData.success(list);
    }

            /*
          接口：添加数据
          * 请求：post请求
          * 参数 pid name
          * 返回值   {"code":200,"message":"提示",data:新增数据的id}
          *路径：http://192.168.235.1:8080/api/type/add
          * */
    @PostMapping("add")
    public ResultData add(Type type){
        Integer id=typeService.add(type);
        return ResultData.success(id);
    }
    @RequestMapping("update")
    public ResultData update(Type type){
        if(type.getIsDel()==null){
            type.setIsDel(0);
        }
        type.setUpdateDate(new Date());
        typeService.update(type);
        return ResultData.success(null);
    }

}
