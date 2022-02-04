package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.logininfo.LoginInfoDAO;
import model.logininfo.LoginInfoVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginInfoDAO dao = new LoginInfoDAO();
		LoginInfoVO vo = new LoginInfoVO();
		vo.setId(request.getParameter("sid"));
		vo.setPassword(request.getParameter("spw"));
		vo.setAuth(request.getParameter("auth"));
		LoginInfoVO data = null;
		ActionForward forward = null;
		if(request.getParameter("auth").equals("s")) {
			data = dao.loginStudent(vo);
			HttpSession session = request.getSession();
			session.setAttribute("user_id", data.getId());
			session.setAttribute("auth", data.getAuth());
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else if(request.getParameter("auth").equals("s")) {
			data = dao.loginAdmin(vo);
			HttpSession session = request.getSession();
			session.setAttribute("user_id", data.getId());
			session.setAttribute("auth", data.getAuth());
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인에 실패하였습니다! 아이디 및 비밀번호를 확인해주세요!'); history.back(-1);</script>");
		}
		
		return forward;
	}
	
}
