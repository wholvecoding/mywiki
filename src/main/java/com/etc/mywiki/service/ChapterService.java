package com.etc.mywiki.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.etc.mywiki.domain.Chapter;
import com.etc.mywiki.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    public Chapter getChapterById(Integer id) {
        return chapterMapper.selectById(id);
    }
    public void updateChapter(Chapter chapter) {
        chapterMapper.updateById(chapter);
    }
    public void deleteChapter(Integer id) {
        chapterMapper.deleteById(id);
    }
    public void addChapter(Chapter chapter) {
        chapterMapper.insert(chapter);
    }
    public List<Chapter> getChapterByEbookId(String ebookId) {
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ebook_id", ebookId);
        return chapterMapper.selectList(queryWrapper);
    }
}
