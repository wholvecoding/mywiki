package com.etc.mywiki.mapper;

import com.etc.mywiki.domain.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    @Delete("delete from Category where id=#{id}")
    public int delete(Category category);
    public int insert(Category record);
    public  int update(Category record);
    @Select("select id,parent,name,sort from Category")
    public List<Category> selectall();
}
