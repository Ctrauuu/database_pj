package com.asd.boot_demo.controller;

import com.asd.boot_demo.dao.Person;
import com.asd.boot_demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private PersonService personService;

    // 显示登录页面（如果你希望返回HTML页面，可不改）
    @GetMapping
    public String showLoginPage() {
        return "login"; // 这里依然是返回login.html，如果你不需要可以去掉
    }

    // 处理登录请求
    @PostMapping
    public ResponseEntity<?> login(@RequestParam String name, @RequestParam String email) {
        try {
            // 尝试根据用户输入的姓名和邮箱验证用户
            Person person = personService.authenticateUser(name, email);
            if (person != null) {
                return ResponseEntity.ok(person);  // 登录成功，返回用户信息
            } else {
                return ResponseEntity.status(400).body("用户名或邮箱错误"); // 登录失败，返回错误信息
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("登录失败：" + e.getMessage());  // 返回服务器错误信息
        }
    }
}
