package high_performance.yuna.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import high_performance.yuna.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberRepository {
	
	private final EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	
	public Member findById(String id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> findByLoginId(String loginId){
		return em.createQuery("select m from Member m where m.memberId = :memberId", Member.class)
				.setParameter("memberId", loginId).getResultList();
	}
	
	public List<Member> findAll(){
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
	
	
	/*
	 * private static Map<Object, Member> store = new HashMap<>();
	 * 
	 * public Member save(Member member) { store.put(member.getClass(), member);
	 * return member; }
	 * 
	 * // 아이디로 회원조회 public Member findById(Long id) { return store.get(id); }
	 * 
	 * // 로그인 회원 조회 public Optional<Member> findByLoginId(String loginId){ return
	 * findAll().stream() .filter(m -> m.getId().equals(loginId)) .findFirst(); }
	 * 
	 * // 전체 회원 조회 public List<Member> findAll(){ return new
	 * ArrayList<>(store.values()); }
	 * 
	 * // 회원 초기화 public void clearStore() { store.clear(); }
	 * 
	 * 
	 */
	

}
