package cafe.injava.java;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(value="loginMember")//배열의 개수와 값이 들어간다. value="{logionMember}"
public class HomeController {
	public String signin(Model model){
		model.addAttribute("loginMember", "로그인 정보");
		return "redirect:/";
	}
	public String singout(SessionStatus status){
		status.isComplete();
		return "redirect:/";
	}
	
	public String login(HttpSession session, Member member) {
		// id,pw->service -> Dao-> is-> save the session
		boolean result = false;
		if(!result){
			
			return "login";
		}else{
			//Member was saved the session!
			session.setAttribute("loginMember", member);
		}
		return "home";

	}
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
class Member {
	
}
