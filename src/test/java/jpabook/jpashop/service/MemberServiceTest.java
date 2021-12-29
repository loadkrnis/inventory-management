package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("charming");

        // when
        Long savedId = memberService.join(member);

        // then
        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 동일한_이름이_존재하면_에러를_반환한다() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("charming");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("charming");

        // when
        memberService.join(member2);

        // then
        Assert.fail("예외가 발생해야 한다.");
    }
}