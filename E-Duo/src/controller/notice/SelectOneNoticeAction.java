package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class SelectOneNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 공지사항 목록에서 특정 공지사항을 클릭할 시에 그 공지사항의 내용을 보여줌
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		vo.setNid(Integer.parseInt(request.getParameter("nid")));
		NoticeVO data = dao.selectOne(vo);
		
		ActionForward forward = null;
		if(data == null) {
			response.setContentType("text/http; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('해당 공지사항을 불러오는데에 실패하였습니다.');history.back(-1);</script>");
		} else {
			request.setAttribute("notice_data", data);
			forward = new ActionForward();
			forward.setPath("notice_detail.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
