package com.fh.controller;

import com.fh.entity.po.Value;
import com.fh.entity.vo.ResultData;
import com.fh.service.ValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("ValueController")
public class ValueController {
    @Resource
    ValueService valueService;


    @GetMapping("getData")
    public ResultData getData(Integer id){
        if(id==null){
            return  ResultData.error(400,"传值异常");
        }
        List<Value> list=valueService.getData(id);
        return ResultData.success(list);
    }
    @PostMapping("add")
    public ResultData add(Value value){
        valueService.add(value);
        return ResultData.success(null);
    }

}
