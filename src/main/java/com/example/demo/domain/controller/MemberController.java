package com.example.demo.domain.controller;

import com.example.demo.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    private ResponseEntity registerMember(@RequestParam String name) throws Exception {
        memberService.save(name);
        return ResponseEntity.ok().build();
    }
}
