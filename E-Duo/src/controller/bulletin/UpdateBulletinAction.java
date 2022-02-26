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
		// 글 수정버튼 클릭 시 DB의 데이터가 수정됨, 이때 bul_id는 사용자가 입력하는 것이 아니고 invisible로 받아옴
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