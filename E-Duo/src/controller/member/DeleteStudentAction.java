package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.logininfo.LoginInfoDAO;
import model.logininfo.LoginInfoVO;

public class DeleteStudentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginInfoDAO dao = new LoginInfoDAO();
		LoginInfoVO vo = new LoginInfoVO();
		HttpSession session = request.getSession();
		vo.setId((String)session.getAttribute("user_id"));
		ActionForward forward = null;
		if(dao.delete(vo)) {
			session.invalidate();
			forward = new ActionForward();
			forward.setPath("index.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원탈퇴 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		
		return forward;
	}

}
