package com.mario.auth.service;

import com.mario.auth.domain.Member;
import com.mario.auth.dto.SignupRequest;
import com.mario.auth.repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signup(@Valid SignupRequest signupRequest) throws IllegalArgumentException {
        String name = signupRequest.getName();
        String email = signupRequest.getEmail();
        String password = signupRequest.getPassword();

        Boolean isExists = memberRepository.existsByEmail(email);

        if (isExists.equals(Boolean.TRUE)) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        Member member = new Member(email, password, name);

        memberRepository.save(member);
    }
}
