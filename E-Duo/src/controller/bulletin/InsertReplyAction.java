package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.ReplyDAO;
import model.bulletin.ReplyVO;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	// 회의 필요, 익명 관련한 column의 필요성
		// 댓글 작성버튼 클릭 시 댓글이 DB에 저장됨
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		vo.setContent(request.getParameter("content"));
		vo.setRegDate(request.getParameter("regDate"));
		vo.setStu_id(request.getParameter("stu_id"));
		
		ActionForward forward = null;
		if(dao.insert(vo)) {
			forward = new ActionForward();
			forward.setPath("bulletin_detail.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글 작성 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}

