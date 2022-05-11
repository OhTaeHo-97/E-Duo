package controller.timetable;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;

public class InsertTimeTableAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		HttpSession session = request.getSession();
		vo.setMy_sub_id(Integer.parseInt(request.getParameter("sub_id")));
		vo.setAcademic_number(request.getParameter("academic_number"));
		vo.setStu_id((String)session.getAttribute("user_id"));
		vo.setCredit(0);
		vo.setGrade(Integer.parseInt(request.getParameter("grade")));
		vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		
		ActionForward forward = null;
		if(dao.insert(vo)) {
			request.setAttribute("grade", Integer.parseInt(request.getParameter("grade")));
			request.setAttribute("semester", Integer.parseInt(request.getParameter("semester")));
			forward = new ActionForward();
			forward.setPath("timetablePage.timetable");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/http; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('시간표를 추가하는 중에 문제가 발생했습니다.');history.back(-1);</script>");
		}
		return forward;
	}

}
