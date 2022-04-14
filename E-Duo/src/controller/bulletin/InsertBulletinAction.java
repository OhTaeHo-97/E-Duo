package controller.bulletin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinVO;
import model.student.StudentDAO;
import model.student.StudentVO;

public class InsertBulletinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글 작성 페이지에서 글 작성을 누르면 DB에 데이터를 insert 함
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		StudentDAO dao2 = new StudentDAO();
		StudentVO vo2 = new StudentVO();
		HttpSession session = request.getSession();
		vo2.setStu_id((String)session.getAttribute("user_id"));
		StudentVO stu_data = new StudentVO();
		stu_data = dao2.selectOne(vo2);
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setImage(request.getParameter("image"));
		vo.setStu_id((String)session.getAttribute("user_id"));
		vo.setTitle(request.getParameter("title"));
		System.out.println(request.getParameter("nickname"));
		if(request.getParameter("nickname") == "닉네임") {
			vo.setNickname(stu_data.getNickname());
		} else {
			vo.setNickname("익명");
		}
		request.setAttribute("category", request.getAttribute("category"));
		ActionForward forward = null;
		if(dao.insert(vo)) {
			forward = new ActionForward();
			forward.setPath("selectCategoryFilterAll.bul");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글 작성 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}
	
}