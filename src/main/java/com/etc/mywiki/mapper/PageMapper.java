package com.etc.mywiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.domain.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper extends BaseMapper<Page> {
    // Custom query methods if needed
}
