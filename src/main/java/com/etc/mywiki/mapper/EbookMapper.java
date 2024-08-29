package com.etc.mywiki.mapper;

import com.etc.mywiki.domain.Ebook;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EbookMapper {

    @Select("select id, author, name, description, cover from ebook ")
    public List<Ebook> getAllBooks();
}
