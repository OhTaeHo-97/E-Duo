package controller.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class GetMyBulletinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		ArrayList<BulletinVO> datas = dao.selectMyBulletin(vo);
		ActionForward forward = null;
		if(datas.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는데에 실패하였습니다!'); history.back(-1);</script>");
		} else {
			request.setAttribute("mybulletin_data", datas);
			forward = new ActionForward();
			forward.setPath("myBoardText.jsp");
			forward.setRedirect(false);
		}
		return forward;
	}
	
}
