package com.example.springboot_mybatisplus.controller;

import com.example.springboot_mybatisplus.bean.Code;
import com.example.springboot_mybatisplus.bean.Message;
import com.example.springboot_mybatisplus.bean.User;
import com.example.springboot_mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Message getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return new Message(Code.GET_SUCCESS, "Get user success", user);
    }

    @GetMapping
    public Message getAllUser() {
        List<User> users = userService.getAllUser();
        return new Message(Code.GET_SUCCESS, "Get all users success", users);
    }

    @PostMapping
    public Message addUser(@RequestBody User user) {
        boolean flag = userService.addUser(user);
        int code = flag ? Code.POST_SUCCESS : Code.POST_ERROR;
        String message = flag ? "Add user success" : "Fail to add user";
        return new Message(code, message, null);
    }

    @DeleteMapping("/{id}")
    public Message delUser(@PathVariable int id) {
        boolean flag = userService.delUser(id);
        int code = flag ? Code.DEL_SUCCESS : Code.DEL_ERROR;
        String message = flag ? "Delete user success" : "Fail to delete user. No id";
        return new Message(code, message, null);
    }

    @PutMapping
    public Message updateUser(@RequestBody User user) {
        boolean flag = userService.updateUser(user);
        int code = flag ? Code.PUT_SUCCESS : Code.PUT_ERROR;
        String message = flag ? "Update success" : "Fail to update user";
        return new Message(code, message, null);
    }
}
