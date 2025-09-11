package chap8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	private static AnnotationConfigApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao dao = ctx.getBean(MemberDao.class);
		
//		Member mem = new Member("wtme3@naver.com","1234", "서재홍", null);
//		dao.insert(mem);
//		System.out.println("입력성공");
		
//		Member member = dao.selectByEmail1("wtme3@naver.com");
//		System.out.println(member);
		
//		Member member2 = dao.selectByEmail2("wtme3@naver.com11");
//		System.out.println(member2);
		
		
		
	}
}
