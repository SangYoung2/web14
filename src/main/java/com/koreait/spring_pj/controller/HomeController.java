package com.koreait.spring_pj.controller;

import com.koreait.spring_pj.vos.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Log4j2
@Controller
public class HomeController {
    @GetMapping("/")
    public String init(){
        log.info("Home Controller 실행");
        return "redirect:/board";
    }

//    @GetMapping("/")
//    public String home(Model model){
//        System.out.println("Controller 실행!");
//        List<BoardVO> boardVOS = Arrays.asList(
//                BoardVO.builder().no(1).title("첫번째").writer("나").writeDate(LocalDate.now()).build(),
//                BoardVO.builder().no(2).title("두번째").writer("너").writeDate(LocalDate.now()).build(),
//                BoardVO.builder().no(3).title("세번째").writer("엄마").writeDate(LocalDate.now()).build(),
//                BoardVO.builder().no(4).title("네번째").writer("아빠").writeDate(LocalDate.now()).build(),
//                BoardVO.builder().no(5).title("다섯번째").writer("누나").writeDate(LocalDate.now()).build()
//        );
//        model.addAttribute("check", false);
//        model.addAttribute("number", 10);
//        model.addAttribute("boardVOS", boardVOS);
//        model.addAttribute("message", "이건 전달받은 메세지입니다.");
//        return "home";
//    }
}
