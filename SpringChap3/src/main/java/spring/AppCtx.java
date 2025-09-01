package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		
		
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterSvc() {
		return new MemberRegisterService(memberDao());
	}
}
