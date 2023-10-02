package com.mysite.member.controller;

import com.mysite.member.dto.MemberDTO;
import com.mysite.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("member/save")
    private String saveForm(){
        return "save";
    }
    @PostMapping("member/save")
    // RequestParam을 통해 name값을 담아오고 옮겨줌
    // ModelAttribute 웬만하면 가독성을 위해 달아줄 것, 안 사용해도 되긴 함
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "index";
    }
}
