package com.etc.mywiki.service;

import com.etc.mywiki.domain.Category;
import com.etc.mywiki.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> selectAllCategories() {
        return categoryMapper.selectList(null);
    }

    public void addCategory(Category category) {
        categoryMapper.insert(category);
    }

    public void deleteCategory(Integer id) {
        categoryMapper.deleteById(id);
    }

    public Category getCategoryById(Integer id) {
        return categoryMapper.selectById(id);
    }

}
