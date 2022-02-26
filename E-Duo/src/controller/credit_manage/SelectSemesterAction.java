package controller.credit_manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;
import model.student.StudentDAO;
import model.student.StudentVO;

public class SelectSemesterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 학점 관리 페이지에서 get 방식으로 받아올 학기마다의 수강과목 리스트
		My_subjectDAO dao = new My_subjectDAO();
		My_subjectVO vo = new My_subjectVO();
		HttpSession session = request.getSession();
		// 학기별 수강과목 불러오기
		vo.setStu_id((String)session.getAttribute("user_id"));
		vo.setGrade(Integer.parseInt(request.getParameter("grade")));
		vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		ArrayList<My_subjectVO> my_sub_datas = dao.selectFilterBySemester(vo);
		request.setAttribute("my_sub_datas", my_sub_datas);
		
		// 내 정보
		StudentDAO dao2 = new StudentDAO();
		StudentVO vo2 = new StudentVO();
		vo2.setStu_id((String)session.getAttribute("user_id"));
		StudentVO stu_data = dao2.selectOne(vo2);
		request.setAttribute("stu_data", stu_data);
		
		ActionForward forward = new ActionForward();
		forward.setPath("CreditManagement.jsp");
		forward.setRedirect(false);
		return forward;
	}

}