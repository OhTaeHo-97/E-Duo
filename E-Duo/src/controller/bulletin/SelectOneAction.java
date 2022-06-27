package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinSet;
import model.bulletin.BulletinVO;

public class SelectOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 게시판 분류별 페이지 혹은 메인페이지의 게시판 top3 글 목록을 눌렀을 때, 글과 댓글이 써져있는 페이지로 이동하는 controller
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		BulletinSet bul_data = null;
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		bul_data = dao.selectOne(vo);
		
		ActionForward forward = null;
		if(bul_data != null) {
			request.setAttribute("bul_data", bul_data);
			forward = new ActionForward();
			forward.setPath("bulletin_detail.jsp");	// 글 하나 세부로 보는 bulletin 세부 페이지로 갈 예정
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글을 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}