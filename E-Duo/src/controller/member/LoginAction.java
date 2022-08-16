package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.loginInfo.LoginInfoDAO;
import model.loginInfo.LoginInfoVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginInfoDAO dao = new LoginInfoDAO();
		LoginInfoVO vo = new LoginInfoVO();
		vo.setStu_id(request.getParameter("sid"));
		vo.setPassword(request.getParameter("spw"));
		vo.setAuth(request.getParameter("auth"));
		LoginInfoVO data = null;
		ActionForward forward = null;
		if(request.getParameter("auth").equals("s")) {
			data = dao.loginStudent(vo);
			if(data == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인에 실패하였습니다! 아이디 및 비밀번호를 확인해주세요!'); history.back(-1);</script>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user_id", data.getStu_id());
				session.setAttribute("auth", data.getAuth());
				session.setAttribute("menu", "");
				forward = new ActionForward();
				forward.setPath("main.do");
				forward.setRedirect(false);
			}
		} else if(request.getParameter("auth").equals("a")) {
			data = dao.loginAdmin(vo);
			if(data == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인에 실패하였습니다! 아이디 및 비밀번호를 확인해주세요!'); history.back(-1);</script>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user_id", data.getStu_id());
				session.setAttribute("auth", data.getAuth());
				session.setAttribute("menu", "");
				forward = new ActionForward();
				forward.setPath("main.do");
				forward.setRedirect(false);
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인에 실패하였습니다! 아이디 및 비밀번호를 확인해주세요!'); history.back(-1);</script>");
		}
		
		return forward;
	}
	
}
