package com.etc.mywiki.service;

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
}
