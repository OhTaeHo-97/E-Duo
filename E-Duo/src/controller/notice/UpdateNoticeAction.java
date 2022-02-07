package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class UpdateNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		vo.setNid(Integer.parseInt(request.getParameter("nid")));
		
		ActionForward forward = null;
		if(dao.update(vo)) {
			request.setAttribute("nid", Integer.parseInt(request.getParameter("nid")));
			forward = new ActionForward();
			forward.setPath("noticeDetail.notice");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/http; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('공지사항을 수정하는 중에 문제가 발생했습니다.');history.back(-1);</script>");
		}
		return forward;
	}

}
