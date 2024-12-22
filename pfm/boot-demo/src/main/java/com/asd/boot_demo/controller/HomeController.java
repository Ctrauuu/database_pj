package com.asd.boot_demo.controller;

import com.asd.boot_demo.dao.Person;
import com.asd.boot_demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private PersonService personService;

    @GetMapping("/") // 根路径
    public String home() {
        return "redirect:/index.html"; // 重定向到静态文件 index.html
    }

    @PostMapping("/login") // 登录处理路径
    public String login(@RequestParam String username, @RequestParam String password) {
        // 使用数据库验证用户名和密码
        Person person = personService.authenticateUser(username, password);
        if (person != null) {
            return "redirect:/admin.html"; // 登录成功跳转到管理页面
        } else {
            return "redirect:/index_error.html";
        }
    }
}
