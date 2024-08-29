package com.etc.mywiki.service;

import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.mapper.EbookMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;



    public List<Ebook> selectAllBooks() {
        return ebookMapper.getAllBooks();
    }
}
