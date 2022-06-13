package controller.timetable;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;

public class InsertSubjectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("aca"));
		System.out.println(request.getParameter("grade"));
		System.out.println(request.getParameter("semester"));
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		vo.setAcademic_number(request.getParameter("aca"));
		vo.setCredit((float)-1.0);
		vo.setGrade(Integer.parseInt(request.getParameter("grade")));
		vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		ActionForward forward = null;
		if(dao.insert(vo)) {
			forward = new ActionForward();
			forward.setPath("timetablePage.timetable");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('과목 추가 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}
}