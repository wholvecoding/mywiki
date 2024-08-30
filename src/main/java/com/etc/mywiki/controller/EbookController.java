package com.etc.mywiki.controller;

import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EbookController {
    @Autowired
    private EbookService ebookService;

    public List<Ebook> selected_all()
    {
        return ebookService.selectAllBooks();
    }
}
