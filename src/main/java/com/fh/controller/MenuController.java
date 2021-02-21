package com.fh.controller;

import com.fh.entity.po.Menu;
import com.fh.entity.vo.ResultData;
import com.fh.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("MenuController")
public class MenuController {
    @Resource
    MenuService menuService;

    @GetMapping("getData")
    public ResultData getData(){
        List<Menu> list=menuService.getData();
        return ResultData.success(list);
    }

    @PostMapping("updateMenu")
    public ResultData updateMenu(Menu menu){
        menuService.updateMenu(menu);
        return ResultData.success(null);
    }

    @PostMapping("addMenu")
    public ResultData addMenu(Menu menu){
        menuService.addMenu(menu);
        return ResultData.success(null);
    }

}
