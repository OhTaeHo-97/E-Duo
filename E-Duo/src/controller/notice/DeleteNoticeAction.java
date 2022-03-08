package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class DeleteNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		vo.setNot_id(Integer.parseInt(request.getParameter("nid")));
		
		ActionForward forward = null;
		if(dao.delete(vo)) {
			forward = new ActionForward();
			forward.setPath("noticePage.notice");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/http; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('공지사항을 삭제하는 중에 문제가 발생했습니다.');history.back(-1);</script>");
		}
		return forward;
	}

}
