package high_performance.yuna.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import high_performance.yuna.domain.Member;
import high_performance.yuna.service.LoginService;
import high_performance.yuna.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	
	// 로그인 페이지 이동
	@GetMapping(value = "/login")
	public String loginForm(@ModelAttribute LoginForm model) {
		return "login/loginForm";
	}
	
	
	@PostMapping(value = "/login") 
	public String login(@Validated @ModelAttribute LoginForm form, 
			BindingResult bindingResult, HttpServletRequest request) {
	  
		if (bindingResult.hasErrors()) { 
			return "login/loginForm"; 
			}
	  
		Optional<Member> loginMemberOpt = loginService.login(form.getLoginId(), form.getPassword());
	  
		if (loginMemberOpt.isEmpty()) { 
			bindingResult.reject("loginFail", "아이디나 비밀번호를 확인해주세요."); 
			return "login/loginForm"; 
			}
	  
		Member loginMember = loginMemberOpt.get(); 
		HttpSession session = request.getSession(); 
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
	  
		return "redirect:/"; 
		}
	 
	
	
	@PostMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/";
	}

}
