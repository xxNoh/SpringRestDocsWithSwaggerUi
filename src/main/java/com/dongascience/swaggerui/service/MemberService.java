package com.dongascience.swaggerui.service;

import com.dongascience.swaggerui.dto.MemberDTO;
import com.dongascience.swaggerui.model.Member;
import com.dongascience.swaggerui.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public MemberDTO.Response findMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return new MemberDTO.Response(member.get());

    }

    public List<MemberDTO.Response> getMemberList() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberDTO.Response> responseDto = new ArrayList<>();
        memberList.stream().forEach(m -> {
            MemberDTO.Response response = new MemberDTO.Response(m);
            responseDto.add(response);
        });

        return responseDto;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(name -> {
                    throw new IllegalStateException("회원 이름 중복 발생");
                });
    }

}
