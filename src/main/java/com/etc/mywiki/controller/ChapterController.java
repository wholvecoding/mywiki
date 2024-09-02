package com.etc.mywiki.controller;

import com.etc.mywiki.domain.Chapter;
import com.etc.mywiki.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books/{id}")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/chapters")
    public List<Chapter> select_chapter( @PathVariable String id){return chapterService.getChapterByEbookId(id);}
}
