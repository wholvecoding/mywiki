package com.etc.mywiki.controller;

import com.etc.mywiki.domain.Category;
import com.etc.mywiki.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    public void addCategory(Category category)
    {
        categoryMapper.insert(category);
    }

    public List<Category> selectAllCategories()
    {
        return categoryMapper.selectList(null);
    }
}
