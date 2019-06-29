package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@TableName("users") //写数据库表名    用途：如果数据库的表名和实体类名称不同时，使用
public class users {
    @TableId    //表示：id
    private int uid;
    @TableField("username")//用途：如果数据库的列名和实体类的属性名不同时，使用
    private String username;
    @TableField("password")
    private String password;
    //属性不能带大写 或者直接  @TableField("isadmin")为小写
    @TableField("isAdmin")
    private int isAdmin;


    public users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
