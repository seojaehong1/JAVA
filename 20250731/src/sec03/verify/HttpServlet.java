package sec03.verify;

abstract class HttpServletex{
	public abstract void service();
}

class LoginServlet extends HttpServletex{
	public void service() {
		System.out.println("로그인합니다.");
	}
}

class FileDownLoatServlet extends HttpServletex{
	public void service() {
		System.out.println("파일 다운로드합니다.");
	}
}

public class HttpServlet{

	public static void main(String[] args) {

		method(new LoginServlet());
		method(new FileDownLoatServlet());

	}
	public static void method(HttpServletex servlet) {
		servlet.service();
	}

}
