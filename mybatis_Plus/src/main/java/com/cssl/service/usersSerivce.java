package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.subject;
import com.cssl.pojo.users;

import java.util.List;
import java.util.Map;

/**
 * 继承自带的IService<T>
 */
public interface usersSerivce extends IService<users> {

    List<users> selectAll();

    public IPage<Map<String,Object>> findAll(int index, int size);

    IPage<subject> adc(int index,int size);
}
