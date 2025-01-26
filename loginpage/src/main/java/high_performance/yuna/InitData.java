package high_performance.yuna;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import high_performance.yuna.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData implements ApplicationRunner{
	
	private final InitService initService;

	@Override
	public void run(ApplicationArguments args) {
		initService.dbInit1();
	}
	
	
	@Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
		
		private final EntityManager em;
		
		public void dbInit1() {
            System.out.println("Init1" + this.getClass());
			Member member = createMember("test", "1111");
			em.persist(member);
		}
		
		private Member createMember(String id, String pw) {
	        Member member = new Member();
	        member.setMemberId(id);
	        member.setMemberPw(pw);
	        return member;
	    }
		
	}
	

}
