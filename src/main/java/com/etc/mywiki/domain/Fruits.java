package com.etc.mywiki.domain;

import org.springframework.stereotype.Repository;

/**
 * Repository注解，表示数据持久层对象
 * ORM——object relation map
 */
@Repository
public class Fruits {
    private String f_id;
    private Integer s_id;
    private String f_name;
    private Double f_price;

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public Double getF_price() {
        return f_price;
    }

    public void setF_price(Double f_price) {
        this.f_price = f_price;
    }
}
