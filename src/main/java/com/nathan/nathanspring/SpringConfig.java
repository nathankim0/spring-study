package com.nathan.nathanspring;

import com.nathan.nathanspring.repository.JdbcTemplateMemberRepository;
import com.nathan.nathanspring.repository.MemberRepository;
import com.nathan.nathanspring.repository.MemoryMemberRepository;
import com.nathan.nathanspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
