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
		// 학생 정보
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO stu_data = dao.selectOne(vo);
		request.setAttribute("stu_data", stu_data);
		
		
		// 현재 자신의 학년, 학기의 수강과목 리스트
		My_subjectDAO dao2 = new My_subjectDAO();
		My_subjectVO vo2 = new My_subjectVO();
		
		// 학년과 학기를 불러올 예정, 만약에 이 페이지에 처음 들어와서 학년과 학기를 받은 것이 없다면, 1학년 1학기를 default 값으로 받아옴
		if(request.getParameter("grade") == null) {
			vo2.setGrade(1);
			vo2.setSemester(1);
		} else {
			vo2.setGrade(Integer.parseInt(request.getParameter("grade")));
			vo2.setSemester(Integer.parseInt(request.getParameter("semester")));
		}		
		vo2.setStu_id((String)session.getAttribute("user_id"));
		ArrayList<My_subjectSet> this_semester_sub_datas = dao2.getMySubjectandcreditByGradeandSemester(vo2);
		request.setAttribute("this_semester_sub_datas", this_semester_sub_datas);
		
		// 이번학기 들은 학점수
		int this_semester_credit = 0;
		for(int i = 0; i< this_semester_sub_datas.size(); i++) {
			this_semester_credit += this_semester_sub_datas.get(i).getSubjectVO().getCredit_num();
		}
		request.setAttribute("this_semester_credit", this_semester_credit);
		
		// 이번학기 학점 평균
		double this_semester_credit_average = 0;
		double temp = 0;
		for(int i = 0; i< this_semester_sub_datas.size(); i++) {
			temp += this_semester_sub_datas.get(i).getSubjectVO().getCredit_num()*this_semester_sub_datas.get(i).getMy_subjectVO().getCredit();
		}
		this_semester_credit_average = temp/this_semester_credit;
		
		// 학점 평균 불러오기 로직
		My_subjectDAO dao3 = new My_subjectDAO();
		My_subjectVO vo3 = new My_subjectVO();
		vo3.setStu_id((String)session.getAttribute("user_id"));
		ArrayList<Double> grade_averages = new ArrayList<Double>();
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				vo3.setGrade(i);
				vo3.setSemester(j);
				ArrayList<My_subjectVO> sub_datas = dao3.selectFilterBySemester(vo3);
				double grade_avg;
				if(sub_datas.size() != 0) {
					int grade_sum = 0;
					for(int k = 0; k < sub_datas.size() ; k++) {
						grade_sum += sub_datas.get(k).getGrade();
					}
					grade_avg = (double) (Math.round(((double)grade_sum/sub_datas.size())*100)/100.0);
				} else {
					grade_avg = 0;
				}
				grade_averages.add(grade_avg);
			}
		}
		request.setAttribute("grade_averages", grade_averages);
		
		// 필요학점은 비동기 처리 예정
		ActionForward forward = new ActionForward();
		forward.setPath("CreditManagement.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
