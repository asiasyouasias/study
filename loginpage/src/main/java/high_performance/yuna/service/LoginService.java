package high_performance.yuna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import high_performance.yuna.domain.Member;
import high_performance.yuna.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

	private final MemberRepository memberRepository;

	/*
	 * public Optional<Member> login(String loginId, String password){ return
	 * memberRepository.findByLoginId(loginId).stream() .filter(member ->
	 * member.getPw().equals(password)) .findFirst(); }
	 */
	
	
	public Optional<Member> login(String loginId, String password) {
		return memberRepository.findByLoginId(loginId).stream()
				.filter(member -> member.getMemberPw().equals(password))
				.findFirst();
	}

	
	
	
	
	/*
	 * @Transactional public void login(Member member) {
	 * 
	 * List<Member> findMembers = memberRepository.findByLoginId(member.getId());
	 * 
	 * if (findMembers.isEmpty()) { throw new
	 * IllegalStateException("존재하지 않는 회원입니다"); } else {
	 * 
	 * } }
	 * 
	 * public List<Member> findMembers() { return memberRepository.findAll(); }
	 */

	
	/*
	 * public Optional<Member> login(String loginId, String password) { return
	 * memberRepository.findByLoginId(loginId) .filter(m ->
	 * m.getPw().equals(password)); // 해싱된 비밀번호 비교 시 BCrypt 사용 }
	 */	 

}
