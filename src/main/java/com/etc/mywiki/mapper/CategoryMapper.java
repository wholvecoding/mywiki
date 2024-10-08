package com.etc.mywiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etc.mywiki.domain.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    // Custom query methods if needed
}
