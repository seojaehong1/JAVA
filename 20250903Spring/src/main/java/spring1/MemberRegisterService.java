package spring1;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	public MemberRegisterService() {
	}


	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}



	public void memberRegister() {
		System.out.println(memberDao.select());
	}
}
