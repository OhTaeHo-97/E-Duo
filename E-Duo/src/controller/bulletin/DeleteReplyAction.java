package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.ReplyDAO;
import model.bulletin.ReplyVO;

public class DeleteReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		vo.setRep_id(Integer.parseInt(request.getParameter("rep_id")));
		
		ActionForward forward = null;
		if(dao.delete(vo) ) {
			forward = new ActionForward();
			forward.setPath("#"); // 글 하나 세부로 보는 bulletin 세부 페이지로 갈 예정
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('댓글 삭제 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
