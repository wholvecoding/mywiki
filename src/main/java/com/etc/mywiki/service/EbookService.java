package com.etc.mywiki.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.etc.mywiki.domain.Chapter;
import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.mapper.EbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;

    public List<Ebook> selectAllBooks() {
        return ebookMapper. selectList(null);
    }

    public Ebook selectAllBooksById(int id) {
        return ebookMapper.selectById(id);
    }

    public List<Ebook> selectBooksByCategoryId(int categoryId) {
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        return ebookMapper.selectList(queryWrapper);
    }
}
