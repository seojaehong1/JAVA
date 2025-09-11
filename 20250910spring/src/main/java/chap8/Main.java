package chap8;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao dao = ctx.getBean(MemberDao.class);
//		Member member = new Member(null, "wtme100@naver.com", "1234", "서재홍8", LocalDateTime.now()); 
//		dao.insert2(member);
//		
//		System.out.println("입력"+member.getId());
		
//		System.out.println(dao.count());
//		Member member = dao.selectByEmail5("wtme99@naver.com");
//		System.out.println(member);
		
		System.out.println(dao.selectAll());
		
	}

}
