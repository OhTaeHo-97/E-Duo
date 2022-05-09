package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinSet;
import model.bulletin.BulletinVO;

public class BulletinUpdatePageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		BulletinSet bul_data = null;
		bul_data = dao.selectOne(vo);
		
		ActionForward forward = null;
		if(bul_data != null) {
			request.setAttribute("category", request.getParameter("category"));
			request.setAttribute("bul_data", bul_data);
			forward = new ActionForward();
			forward.setPath("bulletin_update.jsp");	// 글 하나 세부로 보는 bulletin 세부 페이지로 갈 예정
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글을 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
