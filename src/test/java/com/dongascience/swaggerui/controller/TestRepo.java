package com.dongascience.swaggerui.controller;

import com.dongascience.swaggerui.model.Member;
import com.dongascience.swaggerui.repository.MemberRepository;
import com.dongascience.swaggerui.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRepo {
    @Autowired
    MemberRepository repo = new MemoryMemberRepository();

    @Test
    void 회원_아이디_조회() {

        // given
        Member member = new Member();
        member.setName("spring");
        // when
        Member member2 = repo.save(member);
        Member member3 = repo.findById(member2.getId()).get();

        // then
        assertThat(member2.getId()).isEqualTo(1);
        System.out.println("name = " + member3.getName() + ", id = " + member3.getId());
        
    }
}
