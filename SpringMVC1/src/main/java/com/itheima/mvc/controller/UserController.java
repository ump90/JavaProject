package com.itheima.mvc.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/run")
@RestController
public class UserController {
  @GetMapping
  public String run() {
    return "GET";
  }
  @PostMapping
  public String post(){
    return "ADD";
  }


}
