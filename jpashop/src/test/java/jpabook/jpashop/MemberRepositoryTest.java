package jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberRepositoryTest {
//
//    @Autowired MemberRepository memberRepository;
//
//    /**
//     *
//     *  Test 필드에 Transactional 를 쓸 경우 Rollback 자동이다
//     *  하지만 Rollback (false)로 주게 되면
//     *  그대로 값이 들어간다.
//     */
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testMember () throws Exception {
//        // given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        // when
//        // 해당 맞는 변수 만들기 단축키 option cmd v
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.findById(savedId);
//
//        // then
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        assertThat(findMember).isEqualTo(member);
//
//        // 같은 트랜잭션 안에서 같은 id 값을 가지고 있으면 영속성 컨텍스트 자체가 같기 때문에 true 이다.
//
//    }
//}