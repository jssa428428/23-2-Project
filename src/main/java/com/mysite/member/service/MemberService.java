package com.mysite.member.service;

import com.mysite.member.dto.MemberDTO;
import com.mysite.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {

    }
}
