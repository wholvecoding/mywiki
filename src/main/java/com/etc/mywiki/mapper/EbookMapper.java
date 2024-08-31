package com.etc.mywiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etc.mywiki.domain.Ebook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EbookMapper extends BaseMapper<Ebook> {
    // Custom query methods if needed
}
