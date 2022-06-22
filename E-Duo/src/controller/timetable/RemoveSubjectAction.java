package controller.timetable;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;

public class RemoveSubjectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		System.out.println(request.getParameter("sub_id"));
		vo.setMy_sub_id(Integer.parseInt(request.getParameter("sub_id")));
		int result = dao.removeSubject(vo);
		if(result != 0) {
			result = 1;
		} else {
			result = 0;
		}
		System.out.println(result);
		PrintWriter out = response.getWriter();
		out.write(result + "");
		return null;
	}

}
