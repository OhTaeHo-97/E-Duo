package controller.main;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;
import model.my_subject.My_subjectDAO;
import model.my_subject.My_subjectVO;
import model.student.StudentDAO;
import model.student.StudentVO;

public class ShowMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 게시판마다 글 3개 불러오기
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		String[] category = {"free", "info", "fresh", "ad", "job", "market"};
		for(String item : category) {
			vo.setCategory(item);
			ArrayList<BulletinVO> bul_datas = dao.selectTop3(vo);
			if(bul_datas.size() != 0) {
				request.setAttribute(item + "_datas", bul_datas);
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert(item + '카테고리 데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
			}
		}
		// 내정보 불러오기
		StudentDAO dao2 = new StudentDAO();
		StudentVO vo2 = new StudentVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO data = dao2.selectOne(vo2);
		if(data != null) {
			request.setAttribute("stu_info", data);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보를 불러오는 데에 실패하였습니다.'); history.back(-1);</script>");
		}
		
		// 학점 평균 불러오기 로직 만들어야 됨
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
