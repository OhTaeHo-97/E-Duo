package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.loginInfo.LoginInfoDAO;
import model.loginInfo.LoginInfoVO;

public class CheckIdRedundancyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginInfoDAO dao = new LoginInfoDAO();
		LoginInfoVO vo = new LoginInfoVO();
		vo.setStu_id(request.getParameter("memberId"));
		
		int idCheck = dao.checkId(vo);
		System.out.println(idCheck);
		
		PrintWriter out = response.getWriter();
		out.write(idCheck + "");
		
		return null;
	}
	
}
