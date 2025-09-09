package chap5_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		AnyService anyService = ctx.getBean(AnyService.class);
		anyService.listAll();
	}

}
