package aop1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		SimpleService simpleService = ctx.getBean(SimpleService.class);
		simpleService.doSomething();
		
		ctx.close();
	}

}
