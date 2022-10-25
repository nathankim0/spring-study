package com.nathan.nathanspring.repository;

import com.nathan.nathanspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member Save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
