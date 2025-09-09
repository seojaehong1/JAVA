package spring1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppCtx.class);
		MemberRegisterService meService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		meService.memberRegister();
	}

}
