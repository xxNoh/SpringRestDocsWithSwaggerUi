package com.dongascience.swaggerui.controller;

import com.dongascience.swaggerui.dto.MemberDTO;
import com.dongascience.swaggerui.model.Member;
import com.dongascience.swaggerui.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping(value = "{id}")
    public MemberDTO.Response getMember(@PathVariable("id") Long id) {
        return memberService.findMember(id);
    }

    @GetMapping
    public List<MemberDTO.Response> members() {
        return memberService.getMemberList();

    }

    @PostMapping
    public Map<String, Object> postMember(@RequestBody MemberDTO.Request request) {
        Map<String, Object> returnValue = new HashMap<>();
        Long memberId = memberService.join(request.toEntity());
        returnValue.put("id", memberId);
        returnValue.put("name", request.getName());
        return returnValue;
    }

}
