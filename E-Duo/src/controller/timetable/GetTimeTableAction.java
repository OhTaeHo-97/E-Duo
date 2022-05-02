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
		My_subjectSet set = new My_subjectSet();
		My_subjectVO vo = new My_subjectVO();
		SubjectVO sub_vo = new SubjectVO();
		HttpSession session = request.getSession();
		StudentDAO sdao = new StudentDAO();
		StudentVO svo = new StudentVO();
		svo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO sdata = sdao.selectOne(svo);
		if(request.getParameter("grade") == null) {
			vo.setGrade(sdata.getGrade());
			vo.setSemester(sdata.getSemester());
		} else {
			vo.setGrade(Integer.parseInt(request.getParameter("grade")));
			vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		}
		vo.setStu_id((String)session.getAttribute("user_id"));
		sub_vo.setUni_id(sdata.getUni_id());
		set.setMy_subjectVO(vo);
		set.setSubjectVO(sub_vo);
		
		ArrayList<My_subjectSet> datas = dao.getMyTimetable(set);
		ActionForward forward = null;
		int total_credit_num = 0;
		double total_credit = 0;
		for(My_subjectSet mset : datas) {
			total_credit_num += mset.getSubjectVO().getCredit_num();
			total_credit += mset.getSubjectVO().getCredit_num() * mset.getMy_subjectVO().getCredit();
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
		request.setAttribute("grade", sdata.getGrade());
		request.setAttribute("semester", sdata.getSemester());
		request.setAttribute("table_datas", sub_datas);
		request.setAttribute("total_credit_num", total_credit_num);
		request.setAttribute("avg_credit", avg_credit);
		forward = new ActionForward();
		forward.setPath("timeTable.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
