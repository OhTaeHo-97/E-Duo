package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinSet;
import model.bulletin.BulletinVO;

public class GetBoardTextAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		BulletinSet set = dao.selectOne(vo);
		ActionForward forward = null;
		if(set == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('해당 글을 불러오는데 실패하였습니다!'); history.back(-1);</script>");
		} else {
			request.setAttribute("bulletin_detail", set);
			forward = new ActionForward();
			forward.setPath("#");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
