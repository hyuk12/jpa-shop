package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given (주어지면)
        Member member = new Member();
        member.setName("홍길동");

        // when (이것을 실행하면)
        Long savedId = memberService.join(member);

        // then ( 이렇게 결과가 나와야해)
        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        // when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생을 해야한다.

        // then
        fail("예외가 발생해야 한다.");
    }

}