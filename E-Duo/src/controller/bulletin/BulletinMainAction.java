package controller.bulletin;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;

public class BulletinMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 게시판마다 글 3개 불러오기
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		String[] category = {"free", "info", "fresh", "ad", "job", "market"};
		for(String item : category) {
			vo.setCategory(item);
			ArrayList<BulletinVO> bul_datas = dao.selectTop3(vo);
			if(bul_datas.size() != 0) {
				request.setAttribute(item + "_datas", bul_datas);
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert(item + '카테고리 데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
			}
		}		
		ActionForward forward = new ActionForward();
		forward.setPath("bulletin_main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
