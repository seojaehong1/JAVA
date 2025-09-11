package dept;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		DeptDao dept = ctx.getBean(DeptDao.class);

//		Dept deptstruct = new Dept(50,"서재홍이 바뀌었습니다.", "서");
//		dept.update(deptstruct);
		
		
//		System.out.println(dept.selectAll());
		
//		System.out.println(dept.selectByDeptno(30));
		
//		Dept deptstruct = new Dept(50, "서재홍이 살아났습니다.", "재홍");
//		dept.insert(deptstruct);
		
		dept.delete(50);
	}

}
