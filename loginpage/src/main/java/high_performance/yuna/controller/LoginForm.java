package high_performance.yuna.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginForm {

	@NotEmpty(message = "아이디를 입력하세요")
	private String loginId;
	
	@NotEmpty(message = "패스워드를 입력하세요")
	private String password;
	
}
