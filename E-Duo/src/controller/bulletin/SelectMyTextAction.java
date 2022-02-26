package controller.bulletin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class SelectMyTextAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 내가 작성한 모든 글을 불러옴
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String) session.getAttribute("user_id"));	// Session에 저장된 id 객체를 String 타입으로 형 변환해서 가져온다.
		ArrayList<BulletinVO> bul_datas = dao.selectMyText(vo);
		ActionForward forward = null;
		if(bul_datas.size() != 0) {
			request.setAttribute("bul_datas", bul_datas);
			forward = new ActionForward();
			forward.setPath("myBoardText.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
