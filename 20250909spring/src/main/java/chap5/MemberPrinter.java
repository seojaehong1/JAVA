package chap5;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MemberPrinter {
	@Nullable
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
					member.getId(), member.getEmail(),
					member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	@Autowired(required = false)//@NULLABLE optional 총 3가지의 경우가 있음 특수한 경우가 아니라면 웬만하면 생성자 주입으로 처리하고 지금의 경우는 이 3가지방법을 소개하기 위해 일부러 빈에 등록되지 않게 format를 선언한 것을 사용하기 위한 것입니다
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
}
