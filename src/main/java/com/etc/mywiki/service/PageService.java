package com.etc.mywiki.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.etc.mywiki.domain.Chapter;
import com.etc.mywiki.domain.Page;
import com.etc.mywiki.mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageService {
    @Autowired
    private PageMapper pageMapper;
    public List<Page> getPagesByChapter(int ebookId, int chapterId) {

            QueryWrapper<Page> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("chapter_id", chapterId)
                    .eq("ebook_id",ebookId);
            return pageMapper.selectList(queryWrapper);


    }

    public Page getOnePage(int ebookId, int chapterId,int pageNumber) {
        QueryWrapper<Page> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id", chapterId)
                .eq("ebook_id",ebookId)
                .eq("page_number",pageNumber);
        return pageMapper.selectOne(queryWrapper);
    }
}
