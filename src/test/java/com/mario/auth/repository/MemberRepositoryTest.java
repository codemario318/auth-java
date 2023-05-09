package com.mario.auth.repository;

import com.mario.auth.domain.Member;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest()
@Transactional
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 성공")
    void testSignUpSuccessMember() throws Exception {
        String name = "mario";
        String email = "codemario318@gmail.com";
        String password = "password";

        Member member = new Member(name, email, password);

        Member savedMember = memberRepository.save(member);
        Member foundMember = memberRepository.findById(savedMember.getId()).orElseThrow();

        Assertions.assertThat(savedMember.getId()).isEqualTo(foundMember.getId());
    }
}