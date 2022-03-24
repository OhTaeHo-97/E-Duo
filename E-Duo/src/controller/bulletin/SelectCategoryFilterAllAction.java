package controller.bulletin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class SelectCategoryFilterAllAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 분류별 게시판 글 목록 불러오기(장터 게시판, 자유 게시판 등등)
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		vo.setCategory(request.getParameter("category"));
		ArrayList<BulletinVO> bul_datas = dao.selectCategoryFilterAll(vo);
		ActionForward forward = null;
		if(bul_datas.size() != 0) {
			request.setAttribute("bul_datas", bul_datas);
			forward = new ActionForward();
			forward.setPath("bulletin_category.jsp");
			forward.setRedirect(false);
			for(BulletinVO item : bul_datas) {
				System.out.println(item.getContent());
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}
	
}