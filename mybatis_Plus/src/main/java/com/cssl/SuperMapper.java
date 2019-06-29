package com.cssl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.pojo.subject;
import com.cssl.pojo.users;

import java.util.List;
import java.util.Map;

public interface SuperMapper<T> extends BaseMapper<T>{

    //这里可以放一些公共的方法，不是必须的
    //自定义的方法
    public List<users> selectAll();

    public IPage<Map<String,Object>> userandoptions(IPage page);

    public IPage<subject> ad(IPage page);
}
