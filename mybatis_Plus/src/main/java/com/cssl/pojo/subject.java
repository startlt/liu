package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class subject {
    //sid title TYPE
    private int sid;
    private String title;
    private int type;
    private Set<options> optionss = new HashSet<>();
}
