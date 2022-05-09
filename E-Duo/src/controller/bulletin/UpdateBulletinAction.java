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

public class UpdateBulletinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글 수정버튼 클릭 시 DB의 데이터가 수정됨, 이때 bul_id는 사용자가 입력하는 것이 아니고 invisible로 받아옴
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		StudentDAO dao2 = new StudentDAO();
		StudentVO vo2 = new StudentVO();
		HttpSession session = request.getSession();
		vo2.setStu_id((String)session.getAttribute("user_id"));
		StudentVO stu_data = new StudentVO();
		stu_data = dao2.selectOne(vo2);
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setImage(request.getParameter("image"));
		vo.setTitle(request.getParameter("title"));
		if(request.getParameter("nickname").equals("닉네임")) {
			vo.setNickname(stu_data.getNickname());
		} else {
			vo.setNickname("익명");
		}
		
		ActionForward forward = null;
		if(dao.update(vo) ) {
			request.setAttribute("category", request.getParameter("category"));
			forward = new ActionForward();
			forward.setPath("selectCategoryFilterAll.bul");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글 수정 수행 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}