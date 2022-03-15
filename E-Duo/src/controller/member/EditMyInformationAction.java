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

public class EditMyInformationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		HttpSession session = request.getSession();
		vo.setName(request.getParameter("sname"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setCellphone(request.getParameter("cellphone"));
		vo.setPostcode(Integer.parseInt(request.getParameter("postcode")));
		vo.setAddress(request.getParameter("address"));
		vo.setDetail_address(request.getParameter("detail_address"));
		vo.setRefernece(request.getParameter("reference"));
		UniversityDAO udao = new UniversityDAO();
		UniversityVO uvo = new UniversityVO();
		uvo.setUni_name(request.getParameter("uni_name"));
//		UniversityVO udata = udao.selectUniv(uvo);
//		vo.setUni_id(udata.getUni_id());
		vo.setEmail(request.getParameter("email"));
		vo.setGrade(Integer.parseInt(request.getParameter("grade")));
		vo.setSemester(Integer.parseInt(request.getParameter("semester")));
		vo.setObj_credit(Float.parseFloat("obj_credit"));
		vo.setGraduate_credit(Integer.parseInt("grad_credit"));
		vo.setStu_id((String)session.getAttribute("user_id"));
		
		ActionForward forward= null;
		if(dao.update(vo)) {
			forward = new ActionForward();
			forward.setPath("myInformation.mem");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 변경을 실패하였습니다.'); history.back(-1);</script>");
		}
		
		return forward;
	}
	
}
