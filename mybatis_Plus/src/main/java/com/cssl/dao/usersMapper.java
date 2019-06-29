package com.cssl.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.SuperMapper;
import com.cssl.pojo.subject;
import com.cssl.pojo.users;

import java.util.List;
import java.util.Map;

public interface usersMapper extends SuperMapper<users> {
    @Override
    List<users> selectAll();

    @Override
    IPage<Map<String, Object>> userandoptions(IPage page);

    @Override
    IPage<subject> ad(IPage page);
}
