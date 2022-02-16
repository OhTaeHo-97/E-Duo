package controller.credit_manage;

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

public class ShowCreditManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 학생 정보, 수강 과목 리스트 필요
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO stu_data = dao.selectOne(vo);
		request.setAttribute("stu_data", stu_data);
		My_subjectDAO dao2 = new My_subjectDAO();
		My_subjectVO vo2 = new My_subjectVO();
		vo2.setStu_id((String)session.getAttribute("user_id"));
		
		ArrayList<My_subjectSet> my_sub_datas = dao2.getMySubjectandcredit(vo2);
		
		// 들은 학점수
		int listened_credit = 0;
		for(int i = 0; i< my_sub_datas.size(); i++) {
			listened_credit += my_sub_datas.get(i).getSubjectVO().getCredit_num();
		}
		// 받아야 하는 평균 학점, 현재 학점
		float need_grade = 0;
		float now_grade = 0;
		
		return null;
	}

}
