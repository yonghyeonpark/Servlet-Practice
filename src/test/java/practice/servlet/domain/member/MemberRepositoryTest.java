package practice.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void clear() {
        memberRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member("hi", 20);

        Member savedMember = memberRepository.save(member);

        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    void findAll() {
        Member member1 = new Member("hi", 20);
        Member member2 = new Member("hello", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}
