package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    /**
     *  entity manager 생성
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Member 생성
     * 반환 타입에 Member 를 하지 않고 Long 타입으로 반환하는 이유는?
     * 커맨드와 쿼리를 분리한다. 저장을 하고 나면 최대한 리턴값을 남기지 않으려고 한다.
     */
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

}
