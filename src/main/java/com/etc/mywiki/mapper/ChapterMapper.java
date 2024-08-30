package com.etc.mywiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etc.mywiki.domain.Chapter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {
    // Custom query methods if needed
}
