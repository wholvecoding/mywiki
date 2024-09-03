package com.etc.mywiki.controller;

import com.etc.mywiki.domain.Chapter;
import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class EbookController {
    @Autowired
    private EbookService ebookService;
    @RequestMapping("/allbooks")
    public List<Ebook> selected_all()
    {
        return ebookService.selectAllBooks();
    }
    @RequestMapping("/{id}")
    public Ebook select_id(@PathVariable int id){ return ebookService.selectAllBooksById(id);}
    @RequestMapping("/category/{categoryId}")
    public List<Ebook> select_by_category(@PathVariable int categoryId) {
        return ebookService.selectBooksByCategoryId(categoryId);
    }


}
