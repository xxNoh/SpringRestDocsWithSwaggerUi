//package com.dongascience.swaggerui.controller;
//
//import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import com.epages.restdocs.apispec.ResourceSnippetParameters;
//import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
//
//
//
//
//import com.dongascience.swaggerui.model.Member;
//import com.dongascience.swaggerui.service.MemberService;
//import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.restdocs.payload.PayloadDocumentation;
//import org.springframework.test.web.servlet.MockMvc;º
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MººockMvcResultMatchers;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@WebMvcTest(controllers = MemberController.class)
//@AutoConfigureRestDocs
//class MemberControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    MemberService memberService;
//
//
//
//    @Test
//    void 멤버_저장() throws Exception {
//
//        // given
//        String name = "spring";
//        String json = String.format("{\"name\":\"%s\"}", name);
//
//        // resultActions
//        ResultActions resultActions =  this.mockMvc.perform(RestDocumentationRequestBuilders.post("/member")
//                        .content(json)
//                        .characterEncoding(StandardCharsets.UTF_8)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.ALL))
//                        .andDo(MockMvcResultHandlers.print());
//
//        // when
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
//                        .andDo(MockMvcRestDocumentationWrapper.document("post", "멤버 저장", "멤버 저장",
//                                PayloadDocumentation.requestFields(
//                                        PayloadDocumentation.fieldWithPath("name").type(JsonFieldType.STRING)
//                                                .description("이름")
//                                ),
//                                PayloadDocumentation.responseFields(
//                                    PayloadDocumentation.fieldWithPath("id").type(JsonFieldType.NUMBER)
//                                            .description("아이디")
//                                )
//                        ));
//    }
//
//
//    @Test
//    void 멤머_전체_조회() throws Exception{
//        List<Member> members = new ArrayList<>();
//        Member member = new Member();
//        Member member2 = new Member();
//        member.setId(1L);
//        member.setName("spring");
//
//        member2.setId(2L);
//        member2.setName("spring2");
//        members.add(member);
//        members.add(member);
//
//        Mockito.when(memberService.getMemberList()).thenReturn(members);
//        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/member"))
//            .andDo(MockMvcResultHandlers.print())
//            .andExpect(MockMvcResultMatchers.status().isOk())
//        .andDo(MockMvcRestDocumentationWrapper.document("get All Members", "맴버 전체 조회", "멤버 전체 조회",
//            PayloadDocumentation.responseFields(
//                PayloadDocumentation.fieldWithPath("[]").description("array").optional(),
//                PayloadDocumentation.fieldWithPath("[].id").type(JsonFieldType.NUMBER)
//                        .description("아이디").optional(),
//                PayloadDocumentation.fieldWithPath("[].name").type(JsonFieldType.STRING)
//                        .description("이름").optional()
//            )
//        ));
//
//    }
//
//    @Test
//    void 멤머_단일_조회() throws Exception{
//        // given
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("spring");
//
//        // when
//        Mockito.when(memberService.findMember(1L)).thenReturn(Optional.of(member));
//        ResultActions resultActions = this.mockMvc.perform(RestDocumentationRequestBuilders.get("/member/{id}",1)
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.ALL)
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print());
//
//        // then
//        resultActions
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcRestDocumentationWrapper.document("get member", "멤버 단일 조회", "멤버 단일 조회",
//                        resource(
//                                ResourceSnippetParameters.builder()
//                                .description("멤버 단일 조회")
//                                        .responseFields(
//                                                fieldWithPath("id").description("아이디"),
//                                                fieldWithPath("name").description("이름")
//                                        ).build()
//
//                        )
//                ));
//
//    }
//
//}
