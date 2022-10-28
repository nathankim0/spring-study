package com.nathan.nathanspring;

import com.nathan.nathanspring.repository.JdbcTemplateMemberRepository;
import com.nathan.nathanspring.repository.JpaMemberRepository;
import com.nathan.nathanspring.repository.MemberRepository;
import com.nathan.nathanspring.repository.MemoryMemberRepository;
import com.nathan.nathanspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager entityManager;

    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(entityManager);
    }
}
