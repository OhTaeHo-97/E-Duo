package controller.my_subject;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;

public class SelectSemeseterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		vo.setStu_id(request.getParameter("stu_id"));
		vo.setGrade(Integer.parseInt(request.getParameter("grade")));
		vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		ArrayList<My_subjectVO> my_sub_datas = dao.selectFilterBySemester(vo);
		ActionForward forward = new ActionForward();
		forward.setPath("CreditManagement.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
