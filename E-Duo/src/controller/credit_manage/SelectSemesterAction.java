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

public class SelectSemesterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 학생 정보(학년과 아이디 이름 등을 받아올 예정)
		StudentDAO dao = new StudentDAO();
	    StudentVO vo = new StudentVO();
	    HttpSession session = request.getSession();
	    vo.setStu_id((String)session.getAttribute("user_id"));     
	    StudentVO stu_data = dao.selectOne(vo);
	    request.setAttribute("stu_data", stu_data);
	      
	    // 이번 학기의 수강과목 리스트(밑에 넣을 예정)
	    My_subjectDAO dao2 = new My_subjectDAO();
	    My_subjectVO vo2 = new My_subjectVO();      
	    vo2.setStu_id((String)session.getAttribute("user_id"));
	    vo2.setGrade(stu_data.getGrade());
	    vo2.setSemester(stu_data.getSemester());
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
	    request.setAttribute("this_semester_credit_average", this_semester_credit_average);
	      
	    // 모든 학기 학점 평균 불러오기 로직
	    My_subjectDAO dao3 = new My_subjectDAO();
	    My_subjectVO vo3 = new My_subjectVO();
	    vo3.setStu_id((String)session.getAttribute("user_id"));
	      
	    ArrayList<Double> credit_averages = new ArrayList<Double>();
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
	          credit_averages.add(grade_avg);
	       }
	    }
	    // 각 학기마다 학점 평균
	    request.setAttribute("credit_averages", credit_averages);
	      
	    // 내가 지금까지 들은 학점수 그리고 내가 지금까지 받은 학점 평균, 님은학기 내가 받아야될 학점 평균
	    int all_credit = 0;
	    double credit_now = 0;
	    ArrayList<My_subjectSet> all_sub_datas = dao3.getMyTimetable(vo3);
	    for(int i = 0 ; i < all_sub_datas.size() ; i++) {
	       all_credit += all_sub_datas.get(i).getSubjectVO().getCredit_num();
	       credit_now += all_sub_datas.get(i).getSubjectVO().getCredit_num()*all_sub_datas.get(i).getMy_subjectVO().getCredit();
	    }
	    request.setAttribute("all_credit", all_credit);
	    double need_avg;
	    need_avg = (stu_data.getObj_credit()*all_credit - credit_now) / (stu_data.getGraduate_credit() - all_credit);
	      
	    // 필요학점은 비동기 처리 예정
	    ActionForward forward = new ActionForward();
	    forward.setPath("CreditManagement.jsp");
	    forward.setRedirect(false);
	    return forward;
	}

}