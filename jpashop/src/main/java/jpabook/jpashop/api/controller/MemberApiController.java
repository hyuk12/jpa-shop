package jpabook.jpashop.api.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.api.request.CreateMemberRequest;
import jpabook.jpashop.api.request.UpdateMemberRequest;
import jpabook.jpashop.api.request.member.MemberReqDto;
import jpabook.jpashop.api.response.CreateMemberResponse;
import jpabook.jpashop.api.response.ResultResponse;
import jpabook.jpashop.api.response.UpdateMemberResponse;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<Member> membersV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public ResultResponse membersV2() {
        List<Member> findMembers = memberService.findMembers();

        // entity -> dto
        List<MemberReqDto> collect = findMembers.stream()
                .map(m -> new MemberReqDto(m.getName()))
                .collect(Collectors.toList());

        return new ResultResponse(collect);
    }

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PatchMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable Long id, @RequestBody @Valid UpdateMemberRequest request) {
        memberService.updateMember(id, request.getName());
        Member findMember = memberService.findById(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getName());
    }

    @DeleteMapping("/api/v2/members/{id}")
    public void deleteMemberV2(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
