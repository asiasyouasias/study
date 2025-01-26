package high_performance.yuna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import high_performance.yuna.domain.Member;
import high_performance.yuna.session.SessionConst;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
    	
    	if(loginMember == null) {
    		return "home";
    	}
    	
    	model.addAttribute("member", loginMember);
        log.info("확인");
        return "loginHome";
    }
}
