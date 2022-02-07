package controller.timetable;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.student.StudentDAO;
import model.student.StudentVO;
import model.subject.SubjectDAO;
import model.subject.SubjectVO;

public class getSubjectAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO data = dao.selectOne(vo);
		ActionForward forward = null;
		if(data == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('과목 정보를 가져오는데에 실패하였습니다.'); history.back(-1);</script>");
		} else {
			SubjectDAO sdao = new SubjectDAO();
			SubjectVO svo = new SubjectVO();
			svo.setUni_id(data.getUni_id());
			ArrayList<SubjectVO> datas = sdao.selectAll(svo);
			if(datas.size() == 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('과목 정보를 가져오는데에 실패하였습니다.'); history.back(-1);</script>");
			} else {
				request.setAttribute("subject_datas", datas);
				forward = new ActionForward();
				forward.setPath("#");
				forward.setRedirect(false);
			}
		}
		
		return forward;
	}
	
}
