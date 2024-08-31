package com.etc.mywiki.service;

import com.etc.mywiki.domain.Ebook;
import com.etc.mywiki.domain.User;
import com.etc.mywiki.mapper.EbookMapper;
import com.etc.mywiki.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectAllUsers() {
        return userMapper.selectList(null);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }


    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public void updateUser(User user) {
        userMapper.updateById(user);
    }
}
