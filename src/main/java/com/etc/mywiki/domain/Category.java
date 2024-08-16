package com.etc.mywiki.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Category {
    private int id;
    private Long parent;
    private String name;
    private int sort;


}
