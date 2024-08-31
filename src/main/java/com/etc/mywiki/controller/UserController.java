package com.etc.mywiki.controller;

import com.etc.mywiki.domain.User;
import com.etc.mywiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public List<User> selected_all(){

        return userService.selectAllUsers();
    }

}
