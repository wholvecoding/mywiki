package com.etc.mywiki.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryVo {
    private int id;
    private  Long parent;
    private  String name;
}
