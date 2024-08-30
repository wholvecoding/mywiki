package com.etc.mywiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etc.mywiki.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // Custom query methods if needed
}
