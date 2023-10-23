package com.shop.repository;

import com.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoty extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
