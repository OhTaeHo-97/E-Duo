package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class InsertBulletinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글 작성 페이지에서 글 작성을 누르면 DB에 데이터를 insert 함
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		vo.setCategory(request.getParameter("Category"));
		vo.setContent(request.getParameter("content"));
		vo.setImage(request.getParameter("image"));
		vo.setRegDate(request.getParameter("regDate"));
		vo.setStu_id(request.getParameter("stu_id"));
		vo.setTitle(request.getParameter("title"));
		vo.setNickname(request.getParameter("nickname"));
		
		ActionForward forward = null;
		if(dao.insert(vo)) {
			forward = new ActionForward();
			forward.setPath("bulletin_sort.bul");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글 작성 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}
	
}