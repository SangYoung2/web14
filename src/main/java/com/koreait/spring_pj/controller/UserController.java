package com.koreait.spring_pj.controller;

import com.koreait.spring_pj.domain.UserEntity;
import com.koreait.spring_pj.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(){
       log.info("=== login GET ===");
    }

    @PostMapping("/login")
    public String login_post(){
        log.info("=== login POST ===");
        return "redirect:/board";
    }

    @GetMapping("/register")
    public void register_get(){
        log.info("=== register GET ===");
    }

    @PostMapping("/register")
    public String register_post(UserEntity userEntity) {
        log.info("=== register POST ===");
        log.info(userEntity);
        // 회원가입을 시도한다.
        userService.user_register(userEntity);
        // 로그인창으로 보낸다.
        return "redirect:/users/login";
    }
}
