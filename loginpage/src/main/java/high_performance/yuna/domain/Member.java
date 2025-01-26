package high_performance.yuna.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	
	// 회원 아이디
	@Id 
	@Column(name = "member_id") //sql에 이미 있는 문법을 pk로 쓰면 오류 날 수 있다고 해서.. 
	private String memberId;
	
	// 회원 비밀번호
	@Column(name = "member_pw")
	private String memberPw;

}
