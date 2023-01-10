package com.dongascience.swaggerui.dto;

import com.dongascience.swaggerui.model.Member;
import lombok.Getter;
import lombok.Setter;

public class MemberDTO {

    @Getter
    @Setter
    public static class Request {
        private long id;
        private String name;

        public Member toEntity() {
            Member member = Member.builder()
                    .id(id)
                    .name(name)
                    .build();
            return member;
        };

    }

    @Getter
    @Setter
    public static class Response {
        private long id;
        private String name;

        public Response(Member member) {
            this.id = member.getId();
            this.name = member.getName();
        }
    }

}
