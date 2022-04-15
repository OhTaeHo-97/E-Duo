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
import model.student.StudentDAO;
import model.student.StudentVO;
import model.subject.SubjectVO;

public class GetTimeTableAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		HttpSession session = request.getSession();
		StudentDAO sdao = new StudentDAO();
		StudentVO svo = new StudentVO();
		svo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO sdata = sdao.selectOne(svo);
		vo.setGrade(sdata.getGrade());
		vo.setSemester(sdata.getSemester());
		vo.setStu_id((String)session.getAttribute("user_id"));
		
		ArrayList<My_subjectSet> datas = dao.getMyTimetable(vo);
		ActionForward forward = null;
		if(datas.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('시간표 정보를 가져오는데에 실패하였습니다.'); history.back(-1);</script>");
		} else {
			int total_credit_num = 0;
			double total_credit = 0;
			for(My_subjectSet set : datas) {
				total_credit_num += set.getSubjectVO().getCredit_num();
				total_credit += set.getSubjectVO().getCredit_num() * set.getMy_subjectVO().getCredit();
				System.out.println("total_credit: " + total_credit);
			}
			double avg_credit = (double)Math.round((total_credit / total_credit_num) * 100) / 100;
			ArrayList<SubjectVO> sub_datas = new ArrayList<SubjectVO>();
			for(My_subjectSet mset : datas) {
				sub_datas.add(mset.getSubjectVO());
			}
			System.out.println(total_credit_num);
			System.out.println(avg_credit);
			System.out.println(sub_datas);
			svo = new StudentVO();
			svo.setGrade(sdata.getGrade());
			svo.setSemester(sdata.getSemester());
			request.setAttribute("grade_semester", svo);
			request.setAttribute("table_datas", sub_datas);
			request.setAttribute("total_credit_num", total_credit_num);
			request.setAttribute("avg_credit", avg_credit);
			forward = new ActionForward();
			forward.setPath("timeTable.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
