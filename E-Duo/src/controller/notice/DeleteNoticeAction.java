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
		// 관리자가 공지사항 삭제버튼을 누를 경우 DB에서 데이터를 삭제함
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		vo.setNid(Integer.parseInt(request.getParameter("nid")));
		
		ActionForward forward = null;
		if(dao.delete(vo)) {
			forward = new ActionForward();
			forward.setPath("selectAllNotice.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/http; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('공지사항을 삭제하는 중에 문제가 발생했습니다.');history.back(-1);</script>");
		}
		return forward;
	}

}
