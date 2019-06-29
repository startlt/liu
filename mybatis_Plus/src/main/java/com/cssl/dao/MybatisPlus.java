package com.cssl.dao;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分页必须设置
 */
@Configuration
public class MybatisPlus {
    @Bean
    public PaginationInterceptor  paginationInterceptor(){
        PaginationInterceptor page=new PaginationInterceptor();
        page.setDialectType("mysql");	//方言：那个数据库
        page.setOverflow(true);	//合理化,大于总页数，默认为最后一页（默认有小于零，为第一页）
        return page;
    }
}
