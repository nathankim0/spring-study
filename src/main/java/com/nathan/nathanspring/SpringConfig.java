package com.nathan.nathanspring;

import com.nathan.nathanspring.repository.MemberRepository;
import com.nathan.nathanspring.repository.MemoryMemberRepository;
import com.nathan.nathanspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
