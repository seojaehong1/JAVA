package chap5_1;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	public void select() {
		System.out.println("select 합니다.");
	}
}
