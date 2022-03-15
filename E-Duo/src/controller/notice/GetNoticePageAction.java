package controller.notice;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class GetNoticePageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO dao = new NoticeDAO();
		ArrayList<NoticeVO> datas = dao.selectAll();
		ActionForward forward = null;
		if(datas.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('공지사항을 불러오는데에 실패했습니다.'); history.back(-1);</script>");
		} else {
			request.setAttribute("notice_datas", datas);
			forward = new ActionForward();
			forward.setPath("notice.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
