package controller.timetable;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectSet;
import model.my_subject.My_subjectVO;

public class GetTimeTableAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		if(request.getParameter("grade") == null) {
			vo.setGrade(1);
			vo.setSemester(1);
		} else {
			vo.setGrade(Integer.parseInt(request.getParameter("grade")));
			vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		}
		
		ArrayList<My_subjectSet> datas = dao.getMyTimetable(vo);
		ActionForward forward = null;
		if(datas.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('시간표 정보를 가져오는데에 실패하였습니다.'); history.back(-1);</script>");
		} else {
			int total_credit_num = 0;
			int total_credit = 0;
			for(My_subjectSet set : datas) {
				total_credit_num += set.getSubjectVO().getCredit_num();
				total_credit += set.getSubjectVO().getCredit_num() * set.getMy_subjectVO().getCredit();
			}
			float avg_credit = Math.round(total_credit / total_credit_num * 100) / 100;
			
			request.setAttribute("table_datas", datas);
			request.setAttribute("total_credit_num", total_credit_num);
			request.setAttribute("avg_credit", avg_credit);
			forward = new ActionForward();
			forward.setPath("timeTable.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
