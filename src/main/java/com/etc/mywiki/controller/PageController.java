package com.etc.mywiki.controller;

import com.etc.mywiki.domain.Page;
import com.etc.mywiki.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{ebookId}/{chapterId}")
public class PageController {
    @Autowired
    private PageService pageService;
    @RequestMapping("/allpages")
    public List<Page> selectPagesByChapterId(@PathVariable int ebookId,@PathVariable int chapterId){
        return pageService.getPagesByChapter(ebookId,chapterId);
    }
    @RequestMapping("/{pageNumber}")
    public Page selectOnePageByPageNumber(@PathVariable int ebookId,@PathVariable int chapterId,@PathVariable int pageNumber){
        return pageService.getOnePage(ebookId, chapterId, pageNumber);

    }
}
