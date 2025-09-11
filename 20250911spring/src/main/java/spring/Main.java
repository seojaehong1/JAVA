package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		TimememberDao timemember =  ctx.getBean(TimememberDao.class);
		

	}

}
