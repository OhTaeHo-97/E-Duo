package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.student.StudentDAO;
import model.student.StudentVO;

public class CheckEditNicknameRedundancyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		vo.setNickname(request.getParameter("memberNickname"));
		
		int nicknameCheck = dao.checkNickname(vo);
		System.out.println(nicknameCheck);
		
		PrintWriter out = response.getWriter();
		out.write(nicknameCheck + "");
		
		return null;
	}

}
