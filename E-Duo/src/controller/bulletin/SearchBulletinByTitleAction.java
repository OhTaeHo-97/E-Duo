package controller.bulletin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class SearchBulletinByTitleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 카테고리 + 제목을 통하여 bulletin 데이터를 검색한다
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		vo.setCategory(request.getParameter("category"));
		vo.setTitle(request.getParameter("title"));
		ArrayList<BulletinVO> bul_datas = dao.searchBulletinByContent(vo);
		ActionForward forward = null;
				
		if(bul_datas.size() != 0) {
			request.setAttribute("bul_datas", bul_datas);
			forward = new ActionForward();
			forward.setPath("bulletin_sort.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
