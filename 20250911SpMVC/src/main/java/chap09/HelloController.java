package chap09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class HelloController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/11")
	public String search(String email) {
		Member member = memberDao.selectByEmail(email);
		System.out.println(member);
		return "main";
	}
	
	@GetMapping("/")
	public String main(Model model) {
		System.out.println(memberDao.selectAll());
		model.addAttribute("list", memberDao.selectAll());
		return "main";
	}
	
	@GetMapping("/insertForm")
	public String insertForm(Model model) {		
		return "insertForm";
	}
	
	@GetMapping("/insert")
	public String insert(String name, String email, String password, String regdate) {
		System.out.println(name+","+email+","+password+","+regdate);
		return "insertOk";
	}
	
	
}
