package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    //private final MemberRepository memberRepository= new MemoryMemberRepository();
    // dependecy injection?화 하자..
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
        회원가입
        같은 이름의 회원은 가입이 안된다.
     */
    public Long join(Member member){
        //메소드로 뺴는 단축키 알아오기
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //        Optional<Member> result = memberRepository.findByName(member.getName());
//        // m -> 이런거 처음써봐요..;;
//        result.ifPresent(m -> {
//            throw new IllegalStateException();
//        });

        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이름 중복~");
                });
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
