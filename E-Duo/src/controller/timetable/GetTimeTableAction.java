package controller.timetable;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
import model.timetable.TimeTableVO;

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
		System.out.println("grade: " + request.getParameter("grade"));
		System.out.println("semester: " + request.getParameter("semester"));
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
//		for(My_subjectSet mset : datas) {
//			total_credit_num += mset.getSubjectVO().getCredit_num();
//		}
		ArrayList<TimeTableVO> sub_datas = new ArrayList<TimeTableVO>();
		for(My_subjectSet mset : datas) {
			total_credit_num += mset.getSubjectVO().getCredit_num();
			TimeTableVO tvo = new TimeTableVO();
			tvo.setMy_sub_id(mset.getMy_subjectVO().getMy_sub_id());
			tvo.setSubjectVO(mset.getSubjectVO());
			
			if(mset.getSubjectVO().getFirst_start().equals("NULL")) {
				tvo.setFirst_height(0);
				tvo.setFirst_start(0);
			} else {
				String start = mset.getSubjectVO().getFirst_start();
				String end = mset.getSubjectVO().getFirst_end();
				StringTokenizer st = new StringTokenizer(start, ":");
				int start_hour = Integer.parseInt(st.nextToken());
				double start_min = (double)Math.round((Double.parseDouble(st.nextToken()) / 60) * 100) / 100;
				double start_position = ((start_hour - 9) + start_min) * 100;
				st = new StringTokenizer(end, ":");
				int end_hour = Integer.parseInt(st.nextToken());
				double end_min = (double)Math.round((Double.parseDouble(st.nextToken()) / 60) * 100) / 100;
				double height = ((end_hour - start_hour) + (end_min - start_min)) * 100;
//				System.out.println("start_hour: " + start_hour + ", end_hour: " + end_hour + ", start_min: " + start_min + ", end_min: " + end_min);
//				System.out.println("result: " + (end_hour - start_hour) + (end_min - start_min));
//				System.out.println("height: " + height);
				tvo.setFirst_start(start_position);
				tvo.setFirst_height(height);
			}
			if(mset.getSubjectVO().getSecond_start().equals("NULL")) {
				tvo.setSecond_height(0);
				tvo.setSecond_start(0);
			} else {
				String start = mset.getSubjectVO().getSecond_start();
				String end = mset.getSubjectVO().getSecond_end();
				StringTokenizer st = new StringTokenizer(start, ":");
				int start_hour = Integer.parseInt(st.nextToken());
				double start_min = (double)Math.round((Double.parseDouble(st.nextToken()) / 60) * 100) / 100;
				double start_position = ((start_hour - 9) + start_min) * 100;
				st = new StringTokenizer(end, ":");
				int end_hour = Integer.parseInt(st.nextToken());
				double end_min = (double)Math.round((Double.parseDouble(st.nextToken()) / 60) * 100) / 100;
				double height = ((end_hour - start_hour) + (end_min - start_min)) * 100;
				tvo.setSecond_start(start_position);
				tvo.setSecond_height(height);
			}
			if(mset.getSubjectVO().getThird_start().equals("NULL")) {
				tvo.setThird_height(0);
				tvo.setThird_start(0);
			} else {
				String start = mset.getSubjectVO().getThird_start();
				String end = mset.getSubjectVO().getThird_end();
				StringTokenizer st = new StringTokenizer(start, ":");
				int start_hour = Integer.parseInt(st.nextToken());
				double start_min = (double)Math.round((Double.parseDouble(st.nextToken()) / 60) * 100) / 100;
				double start_position = ((start_hour - 9) + start_min) * 100;
				st = new StringTokenizer(end, ":");
				int end_hour = Integer.parseInt(st.nextToken());
				double end_min = (double)Math.round((Double.parseDouble(st.nextToken()) / 60) * 100) / 100;
				double height = ((end_hour - start_hour) + (end_min - start_min)) * 100;
				tvo.setThird_start(start_position);
				tvo.setThird_height(height);
			}
			
			sub_datas.add(tvo);
		}
		System.out.println(total_credit_num);
		System.out.println(sub_datas);
		request.setAttribute("grade", vo.getGrade());
		request.setAttribute("semester", vo.getSemester());
		request.setAttribute("table_datas", sub_datas);
		request.setAttribute("total_credit_num", total_credit_num);
		forward = new ActionForward();
		forward.setPath("timeTable.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
