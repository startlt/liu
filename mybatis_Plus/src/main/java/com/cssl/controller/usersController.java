package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.options;
import com.cssl.pojo.subject;
import com.cssl.pojo.users;
import com.cssl.service.usersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class usersController {
    public usersController() {
        System.out.println("usersController");
    }

    @Autowired
    private usersSerivce uService;

    @RequestMapping("form1/{pageIndex}/{pageSize}")
    public String form(Model model, @PathVariable int pageIndex,@PathVariable int pageSize){
        //list()查询所有数据
        //List<users> user = uService.list(new QueryWrapper<users>().orderByDesc("uid"));
        IPage<users> pg = uService.page(new Page<users>(pageIndex,pageSize));
        for (users u:pg.getRecords()){
            System.out.println("user:"+u.getUsername()+"\t"+u.getUid());
        }
        model.addAttribute("user",pg);
        return "success";
    }

    @RequestMapping("findAll")
    public String findAll2(Model model){
        List<users> mapIPage = uService.selectAll();
        for (users u:mapIPage){
            System.out.println("u:"+u.getUsername());
        }
        model.addAttribute("user",mapIPage);
       // return "success";
        return "";
    }
    @RequestMapping("like")
    public void like2(){
        List<users> u=uService.list(new QueryWrapper<users>().like("username","紫").orderByDesc("uid"));
        for (users user:u){
            System.out.println("user:"+user.getUsername()+"\t"+user.getUid()+"\t"+user.getPassword());
        }
    }
    @RequestMapping("upd")
    public void upd(){
        users u=new users();
        u.setUsername("admin");
        //eq()相等于修改的条件，update()第一个参数为要修改的内容
        boolean  is=uService.update(u,new  UpdateWrapper<users>().eq("uid","1"));
        if(is){
            System.out.println("修改成功！");
        }
    }
    @RequestMapping("insert")
    public void insert(){
        users u=new users();
        u.setUsername("黑寡妇");
        u.setPassword("32");
        List<users> cc=new ArrayList<>();
        cc.add(u);
        cc.add(new users("spiderman","123"));
        //单个添加
        //boolean save = uService.save(u);
        boolean save=uService.saveBatch(cc);//批量添加
        if(save){
            System.out.println("添加成功");
        }
    }
    @RequestMapping("del/{uid}")
    public void del(@PathVariable int uid){
        //根据uid删除
       // boolean b = uService.removeById(uid);
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(6);
        boolean b=uService.removeByIds(list);//根据uid批量删除
        if(b){
            System.out.println("删除成功");
        }
    }
    @RequestMapping("select")
    public void select(){
        //根据id查询
        //users byId = uService.getById(1);
        //根据条件查一个
        users byId= uService.getOne(new QueryWrapper<users>().eq("username","admin"));
        System.out.println("by:"+byId.getUsername()+"\t"+byId.getPassword());

        //根据多个id查询
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        Collection<users> u = uService.listByIds(list);
        for (users us:u){
            System.out.println("us:"+us.getUsername()+"\t"+us.getPassword());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("uid",1);
        map.put("username","admin");
        //根据map为条件
        Collection<users> u2 = uService.listByMap(map);
        for (users us:u2){
            System.out.println("us:"+us.getUsername()+"\t"+us.getPassword());
        }
        //查询所有数据  还不如用list()
        List<Map<String, Object>> maps = uService.listMaps();
        for (Map<String,Object> m:maps){
            for (Object s:m.keySet()){
                System.out.println(s+"m:"+m.get(s));
            }
        }
    }
    @RequestMapping("fenye/{pageindex}/{pageSize}")
    public void fenye(@PathVariable int pageindex,@PathVariable int pageSize){
        System.out.println(pageindex+"\t"+pageSize);
       /* IPage<Map<String, Object>> all = uService.findAll(pageindex, pageSize);
        System.out.println("总记录数："+all.getTotal()+"总页数:"+all.getPages());
        System.out.println("all.getRecords:"+all.getRecords());*/

        System.out.println("==================================");
        IPage<subject> adc = uService.adc(16, 3);
        for (subject s:adc.getRecords()){
                System.out.println("sb:"+s.getTitle());
            for (options o:s.getOptionss()){
                System.out.println("o:"+o.getContent());
            }
        }

    }

}
