package com.fh.service.impl;

import com.fh.dao.MenuDao;
import com.fh.entity.po.Menu;
import com.fh.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuDao menuDao;

    @Override
    public List<Menu> getData() {
        List<Menu> list=menuDao.getData();
        return list;
    }

    @Override
    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    @Override
    public void addMenu(Menu menu) {
        menu.setCreateDate(new Date());
        menu.setAuthor("郑洋");
        menu.setIsDel(0);
        menuDao.addMenu(menu);
    }
}
