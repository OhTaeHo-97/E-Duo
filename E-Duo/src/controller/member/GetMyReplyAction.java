package controller.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.ReplyDAO;
import model.bulletin.ReplyVO;

public class GetMyReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		ArrayList<ReplyVO> datas = dao.selectMyReply(vo);
		ActionForward forward = null;
		if(datas.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는데에 실패하였습니다!'); history.back(-1);</script>");
		} else {
			request.setAttribute("myreply_data", datas);
			forward = new ActionForward();
			forward.setPath("myBoardReply.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
