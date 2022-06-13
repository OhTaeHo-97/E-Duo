package controller.timetable;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;

public class DeleteTimeTableAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		vo.setAcademic_number(request.getParameter("academic_number"));
		
		ActionForward forward = null;
		if(dao.delete(vo)) {
			forward = new ActionForward();
			forward.setPath(null);
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('시간표를 삭제하는 중에 문제가 발생했습니다.');history.back(-1);</script>");
		}
		return forward;
	}

}
