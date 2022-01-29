package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class UpdateBulletinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setImage(request.getParameter("image"));
		vo.setRegDate(request.getParameter("regDate"));
		vo.setStu_id(request.getParameter("stu_id"));
		vo.setTitle(request.getParameter("title"));
		
		ActionForward forward = null;
		if(dao.update(vo) ) {
			forward = new ActionForward();
			forward.setPath("bulletin_sort.bul");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글 수정 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
