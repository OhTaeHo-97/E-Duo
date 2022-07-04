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
	   
      // 학생 정보(학년과 아이디 이름 등을 받아올 예정)
      StudentDAO dao = new StudentDAO();
      StudentVO vo = new StudentVO();
      HttpSession session = request.getSession();
      vo.setStu_id((String)session.getAttribute("user_id"));
      StudentVO stu_data = dao.selectOne(vo);
      request.setAttribute("stu_data", stu_data);
      
      // 학생의 수강과목 전체 목록
      My_subjectDAO dao2 = new My_subjectDAO();
      My_subjectVO vo2 = new My_subjectVO();
      vo2.setStu_id((String)session.getAttribute("user_id"));
      ArrayList<My_subjectSet> sub_datas = dao2.selectAllMy_subject(vo2);
      
      // 페이지의 현재 수강과목을 받아올 예정
      @SuppressWarnings("unchecked")
	  ArrayList<My_subjectSet>[] sort = new ArrayList[8];
      for(int i = 0 ; i < 8 ; i++) {
    	  sort[i] = new ArrayList<My_subjectSet>();
      }           
      float credit_sum = 0;
      float credit_num_sum = 0;
      for(int i = 0 ; i < sub_datas.size() ; i++) {
    	  // 학점수, 학점 평균
    	  float credit_num = sub_datas.get(i).getSubjectVO().getCredit_num();
    	  credit_num_sum += credit_num;
    	  credit_sum += sub_datas.get(i).getMy_subjectVO().getCredit()*credit_num;
    	  
    	  // 학년, 학기별로 구분하기 위한 로직
    	  int temp_grade = sub_datas.get(i).getMy_subjectVO().getGrade();
    	  int temp_semester = sub_datas.get(i).getMy_subjectVO().getSemester();
    	  int idx = (temp_grade-1)*2 + temp_semester - 1;
    	  sort[idx].add(sub_datas.get(i));
      }
      
      // 각 학년마다의 학점 평균
      float[] credit_averages = new float[8];
      for(int i = 0 ; i < 8 ; i++) {
    	  float temp_credit = 0;
    	  int temp_credit_num = 0;
    	  for(int j = 0 ; j < sort[i].size() ; i++) {
    		  float temp = sort[i].get(j).getSubjectVO().getCredit_num();
    		  temp_credit += sort[i].get(j).getMy_subjectVO().getCredit()* temp;
    		  temp_credit_num += temp;
    	  }
    	  credit_averages[i] = temp_credit/temp_credit_num;
      }
      // 학년 학기마다의 학점 평균
      request.setAttribute("credit_averages", credit_averages);
      
      // 필요 평균 학점
      float need_credit = (stu_data.getGraduate_credit()*stu_data.getObj_credit() - credit_sum)/(stu_data.getGraduate_credit() - credit_num_sum);
      request.setAttribute("need_credit", need_credit);
      
      // 학점 평균
      float credit_average = credit_sum/credit_num_sum;
      request.setAttribute("credit_average", credit_average);
      
      // 들은 학점수
      request.setAttribute("credit_num_sum", credit_num_sum);
      
      if(request.getParameter("grade") == null || request.getParameter("grade").equals("")) {
    	  stu_data.getGrade();
    	  stu_data.getSemester();
      } else {    	  
    	  // 이번학기 수강과목 데이터
    	  int grade = Integer.parseInt(request.getParameter("grade"));
    	  int semester = Integer.parseInt(request.getParameter("semester"));
    	  request.setAttribute("now_sub_datas", sort[(grade-1)*2 + semester - 1]);
      }
      
      ActionForward forward = new ActionForward();
      forward.setPath("CreditManagement.jsp");
      forward.setRedirect(false);
      return forward;
   }

}