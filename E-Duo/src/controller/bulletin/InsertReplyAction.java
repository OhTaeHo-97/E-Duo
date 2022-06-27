package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.ReplyDAO;
import model.bulletin.ReplyVO;
import model.student.StudentDAO;
import model.student.StudentVO;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	// 회의 필요, 익명 관련한 column의 필요성
		// 댓글 작성버튼 클릭 시 댓글이 DB에 저장됨
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		vo.setContent(request.getParameter("content"));
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		
		StudentDAO dao2 = new StudentDAO();
		StudentVO vo2 = new StudentVO();
		vo2.setStu_id((String)session.getAttribute("user_id"));
		StudentVO stu_data = new StudentVO();
		stu_data = dao2.selectOne(vo2);
		vo.setNickname(request.getParameter("nickname"));
		System.out.println(request.getParameter("nickname"));
		if(request.getParameter("nickname").equals("닉네임")) {
			vo.setNickname(stu_data.getNickname());
		} else {
			vo.setNickname("익명");
		}
		ActionForward forward = null;
		if(dao.insert(vo)) {
			request.setAttribute("category", request.getAttribute("category"));
			request.setAttribute("bul_id", Integer.parseInt(request.getParameter("bul_id")));
			forward = new ActionForward();
			forward.setPath("bulletin_detail.bul");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글 작성 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}

