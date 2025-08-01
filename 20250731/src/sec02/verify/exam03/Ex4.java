package sec02.verify.exam03;



class Controller{
	public MemberService service;

	public void setService(MemberService service) {
		this.service = service;
	}
}

class Service{
	public void login() {
		System.out.println("로그인");
	}
}
class MemberService extends Service{

	@Override
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("멤버서비스로그인");
	}
	
}
class AService extends MemberService{

	@Override
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("a서비스 로그인");
	}
	
}
class BoardService extends Service{}
class DService extends BoardService{}



public class Ex4 {
	public static void main(String[] args) {
		Controller con = new Controller();
		con.setService(new MemberService());
		con.service.login();
	}

}
