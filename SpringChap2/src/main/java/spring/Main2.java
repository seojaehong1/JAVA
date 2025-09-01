package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter2", Greeter.class);
		System.out.println(g==g2);
		ctx.close();
		
	}

}
