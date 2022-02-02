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
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String) session.getAttribute("stu_id"));	// 세션에 아이디를 저장해놓고 session에서 아이디를 받아올 예정(변수명이 stu_id 에서 id로 바뀔 수 있음)
		ArrayList<ReplyVO> rep_datas = dao.selectMyReply(vo);	// rep_datas로 데이터를 받아올 예정
		ActionForward forward = null;
		if(rep_datas.size() != 0) {
			forward = new ActionForward();
			forward.setPath("myBoardReply.jsp");	//html 페이지 jsp로 수정예정
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
