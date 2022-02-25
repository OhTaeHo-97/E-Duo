package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.student.StudentDAO;
import model.student.StudentVO;
import model.university.UniversityDAO;
import model.university.UniversityVO;

public class GetMyInformationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		HttpSession session = request.getSession();
		vo.setStu_id((String)session.getAttribute("user_id"));
		StudentVO data = dao.selectOne(vo);
		ActionForward forward = null;
		if(data != null) {
			UniversityDAO udao = new UniversityDAO();
			UniversityVO uvo = new UniversityVO();
			uvo.setUni_id(data.getUni_id());
			UniversityVO udata = udao.selectOne(uvo);
			if(udata == null) {
				return null;
			} else {
				request.setAttribute("stu_info", data);
				request.setAttribute("univ", udata.getUni_name());
				forward = new ActionForward();
				forward.setPath("PersonalInformationEditPage.jsp");
				forward.setRedirect(false);
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보를 불러오는 데에 실패하였습니다.'); history.back(-1);</script>");
		}
		
		return forward;
	}

}
