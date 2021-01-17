package com.fh.service;

import com.fh.entity.po.Value;

import java.util.List;

public interface ValueService {

    List<Value> getData(Integer id);

    void add(Value value);

    void update(Value value);

    void delete(Integer id);
}
