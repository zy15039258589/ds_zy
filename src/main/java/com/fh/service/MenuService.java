package com.fh.service;

import com.fh.entity.po.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getData();

    void updateMenu(Menu menu);

    void addMenu(Menu menu);
}
