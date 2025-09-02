package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDao memberdao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberdao());
	}
	
	
	@Bean
	public ChangePasswordService changePasswordService(MemberDao memberDao) {
		ChangePasswordService changePasswordService = new ChangePasswordService();
		changePasswordService.setMemberDao(memberDao);
		return changePasswordService;
	}
}
