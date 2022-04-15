package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.loginInfo.LoginInfoDAO;
import model.loginInfo.LoginInfoVO;

public class CheckUserAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginInfoDAO dao = new LoginInfoDAO();
		LoginInfoVO vo = new LoginInfoVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		vo.setPassword(request.getParameter("spw"));
		LoginInfoVO data = dao.loginStudent(vo);
		ActionForward forward = null;
		if(data == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 비밀번호를 입력하셨습니다.'); history.back(-1);</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("myInfo.mem");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
