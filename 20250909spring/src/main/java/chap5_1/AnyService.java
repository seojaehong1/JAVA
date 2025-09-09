package chap5_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnyService {
	
	@Autowired
	private MemberDao memberDao;
	
	public void listAll() {
		memberDao.select();
	}
}
