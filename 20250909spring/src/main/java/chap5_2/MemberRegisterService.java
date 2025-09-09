package chap5_2;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;

	public MemberRegisterService() {
	}
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
