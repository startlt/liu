package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.usersMapper;
import com.cssl.pojo.subject;
import com.cssl.pojo.users;
import com.cssl.service.usersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
//@AutoConfigureAfter({})
public class usersSerivceImpl extends ServiceImpl<usersMapper,users> implements usersSerivce {

    @Autowired
    private usersMapper uMapper;
    @Override
    public List<users> selectAll() {
        return uMapper.selectAll();
    }

    @Override
    public IPage<Map<String, Object>> findAll(int index, int size) {
        Page<Map<String,Object>> page=new Page<>(index,size);
        return uMapper.userandoptions(page);
    }

    @Override
    public IPage<subject> adc(int index, int size) {
        Page<subject> page=new Page<>(index,size);
        return uMapper.ad(page);

    }
}
