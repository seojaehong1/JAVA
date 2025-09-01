package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import dao.EmpDAO;
import dto.DeptDTO;
import dto.EmpDTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/list") || com.equals("/")) {
			EmpDAO dao = new EmpDAO();
			List<EmpDTO> list = dao.selectList();
			request.setAttribute("list", list);
			view = "list.jsp";
		
		} else if (com.equals("/insertForm")) {
			view = "redirect:insertForm.jsp";
		} else if(com.equals("/insert")){
			String empno = request.getParameter("empno");
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			String mgr = request.getParameter("mgr");
			String hiredate = request.getParameter("hiredate");
			String sal = request.getParameter("sal");
			String comm = request.getParameter("comm");
			String deptno = request.getParameter("deptno");
			EmpDAO dao = new EmpDAO();
			dao.insertOne(new EmpDTO(Integer.parseInt(empno), ename, job, Integer.parseInt(mgr),
					hiredate, Integer.parseInt(sal), Integer.parseInt(comm), Integer.parseInt(deptno)));
			view = "redirect:list";
		
		} else if(com.equals("/delete")){
			String empno = request.getParameter("empno");
			EmpDAO dao = new EmpDAO();
			dao.deleteOne(Integer.parseInt(empno));
			view = "redirect:list";
		} else if(com.equals("/updateForm")){
			String empno = request.getParameter("empno");
			EmpDAO dao = new EmpDAO();
			EmpDTO dto = dao.selectOne(Integer.parseInt(empno));
			request.setAttribute("dto", dto);
			view = "updateForm.jsp";
		} else if(com.equals("/update")){
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			String mgr= request.getParameter("mgr");
			String sal = request.getParameter("sal");
			String comm = request.getParameter("comm");
			String deptno = request.getParameter("deptno");
			EmpDAO dao = new EmpDAO();
			System.out.println(empno);
			dao.updateOne(empno, new EmpDTO(ename, job, Integer.parseInt(mgr), Integer.parseInt(sal),
					Integer.parseInt(comm), Integer.parseInt(deptno)));
			view = "redirect:list";
		}
		
		if (com.equals("/list2")) {
			DeptDAO dao = new DeptDAO();
			List<DeptDTO> list2 = dao.selectList2();
			request.setAttribute("list2", list2);
			view = "list2.jsp";
		
		} else if (com.equals("/insertForm2")) {
			view = "redirect:insertForm2.jsp";
		} else if(com.equals("/insert2")){
			String deptno = request.getParameter("deptno");
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			DeptDAO dao = new DeptDAO();
			dao.insertOne2(new DeptDTO(Integer.parseInt(deptno), dname, loc));
			view = "redirect:list2";
		
		} else if(com.equals("/delete2")){
			String deptno = request.getParameter("deptno");
			DeptDAO dao = new DeptDAO();
			dao.deleteOne2(Integer.parseInt(deptno));
			view = "redirect:list2";
		} else if(com.equals("/updateForm2")){
			String deptno = request.getParameter("deptno");
			DeptDAO dao = new DeptDAO();
			DeptDTO dto = dao.selectOne2(Integer.parseInt(deptno));
			request.setAttribute("dto", dto);
			view = "updateForm2.jsp";
		} else if(com.equals("/update2")){
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			DeptDAO dao = new DeptDAO();
			dao.updateOne2(deptno, new DeptDTO(deptno,dname, loc));
			view = "redirect:list2";
		}
		
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
