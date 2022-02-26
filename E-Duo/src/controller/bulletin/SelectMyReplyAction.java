package controller.bulletin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.ReplyDAO;
import model.bulletin.ReplyVO;

public class SelectMyReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 내가 작성한 모든 reply 데이터를 불러옴
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String) session.getAttribute("user_id"));	// session에 저장된 user의 아이디를 받아옴
		ArrayList<ReplyVO> rep_datas = dao.selectMyReply(vo);
		ActionForward forward = null;
		if(rep_datas.size() != 0) {
			request.setAttribute("rep_datas", rep_datas);
			forward = new ActionForward();
			forward.setPath("myBoardReply.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}