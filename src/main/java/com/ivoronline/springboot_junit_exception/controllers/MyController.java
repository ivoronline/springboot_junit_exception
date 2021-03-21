package com.ivoronline.springboot_junit_exception.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/Hello")
  public String hello() throws Exception {
    if (1 == 1) { throw new IllegalArgumentException("Argument is missing"); }
    return "Hello from Controller";
  }

}
