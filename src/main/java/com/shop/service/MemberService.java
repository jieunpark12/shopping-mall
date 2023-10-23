package com.shop.service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepositoty memberRepositoty;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepositoty.save(member);
    }

    public void validateDuplicateMember(Member member) {
        Member findMember = memberRepositoty.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
