package chap5_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MemberInfoPrinter {
	@Autowired
	private MemberDao memDao;
	@Autowired
	@Qualifier("memberSummaryPrinter")
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}


	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}


	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

}
