package com.etc.mywiki.controller;

import java.util.List;

import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.service.EbookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @Resource
    private EbookService ebookService;
    @GetMapping("/allbooks")
    public List<Ebook> selected_all(){
        System.out.println(ebookService.selectAllBooks());
        return ebookService.selectAllBooks();
    }


}
