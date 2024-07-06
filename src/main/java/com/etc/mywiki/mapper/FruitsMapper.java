package com.etc.mywiki.mapper;

import com.etc.mywiki.domain.Fruits;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitsMapper {
    @Select("select f_id,s_id,f_name,f_price from fruits")
    public List<Fruits> getFruits();

    @Select("select f_id,s_id,f_name,f_price from fruits where f_name like concat('%',#{f_name},'%')")
    public List<Fruits> getFruitsByName(String f_name);
}
