package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.loginInfo.LoginInfoDAO;
import model.loginInfo.LoginInfoVO;
import model.student.StudentDAO;
import model.student.StudentVO;
import model.university.UniversityDAO;
import model.university.UniversityVO;

public class RegisterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginInfoDAO ldao = new LoginInfoDAO();
		LoginInfoVO lvo = new LoginInfoVO();
		lvo.setStu_id(request.getParameter("stu_id"));
		lvo.setPassword(request.getParameter("password"));
		
		ActionForward forward = null;
		if(ldao.insert(lvo)) {
			StudentDAO dao = new StudentDAO();
			StudentVO vo = new StudentVO();
			vo.setAddress(request.getParameter("address"));
			vo.setBirth(request.getParameter("birth"));
			vo.setCellphone(request.getParameter("cellphone"));
			vo.setDetail_address(request.getParameter("detail_address"));
			vo.setEmail(request.getParameter("email"));
			vo.setGender(request.getParameter("gender"));
			vo.setGrade(Integer.parseInt(request.getParameter("grade")));
			if(request.getParameter("graduate_credit") == "") {
				vo.setGraduate_credit(0);
			} else {
				vo.setGraduate_credit(Integer.parseInt(request.getParameter("graduate_credit")));
			}
			vo.setName(request.getParameter("s_name"));
			vo.setObj_credit((float)3.0);
			vo.setPostcode(Integer.parseInt(request.getParameter("postcode")));
			vo.setRefernece(request.getParameter("reference"));
			vo.setSemester(Integer.parseInt(request.getParameter("semester")));
			vo.setStu_id(request.getParameter("stu_id"));
			vo.setUni_id(Integer.parseInt(request.getParameter("university")));
			vo.setNickname(request.getParameter("nickname"));
			
			if(dao.insert(vo)) {
				forward = new ActionForward();
				forward.setPath("login.jsp");
				forward.setRedirect(false);
			} else {
				response.setContentType("test/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("alert('회원가입에 실패하였습니다.'); history.back(-1);");
			}
		} else {
			response.setContentType("test/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("alert('회원가입에 실패하였습니다.'); history.back(-1);");
		}
		
		return forward;
	}

}
