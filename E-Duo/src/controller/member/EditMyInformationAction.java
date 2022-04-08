package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.loginInfo.LoginInfoDAO;
import model.loginInfo.LoginInfoVO;
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
		String new_pw = request.getParameter("new_upw");
		ActionForward forward = null;
		if(new_pw.equals("") || new_pw == null) {
			vo.setName(request.getParameter("uname"));
			vo.setNickname(request.getParameter("nickname"));
			vo.setCellphone(request.getParameter("phone"));
			vo.setPostcode(Integer.parseInt(request.getParameter("postcode")));
			vo.setAddress(request.getParameter("address"));
			vo.setDetail_address(request.getParameter("detail_address"));
			vo.setRefernece(request.getParameter("reference"));
			vo.setUni_id(Integer.parseInt(request.getParameter("university")));
			vo.setEmail(request.getParameter("email"));
			vo.setGrade(Integer.parseInt(request.getParameter("grade")));;
			vo.setSemester(Integer.parseInt(request.getParameter("term")));
			vo.setObj_credit(Float.parseFloat(request.getParameter("obj_credit")));
			vo.setGraduate_credit(Integer.parseInt(request.getParameter("graduate_credit")));
			vo.setStu_id((String)session.getAttribute("user_id"));
			if(dao.update(vo)) {
				forward = new ActionForward();
				forward.setPath("myInfo.mem");
				forward.setRedirect(false);
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원정보 변경을 실패하였습니다.'); history.back(-1);</script>");
			}
		} else {
			LoginInfoDAO ldao = new LoginInfoDAO();
			LoginInfoVO lvo = new LoginInfoVO();
			lvo.setStu_id((String)session.getAttribute("user_id"));
			if(ldao.update(lvo)) {
				vo.setName(request.getParameter("uname"));
				vo.setNickname(request.getParameter("nickname"));
				vo.setCellphone(request.getParameter("phone"));
				vo.setPostcode(Integer.parseInt(request.getParameter("postcode")));
				vo.setAddress(request.getParameter("address"));
				vo.setDetail_address(request.getParameter("detail_address"));
				vo.setRefernece(request.getParameter("reference"));
				vo.setUni_id(Integer.parseInt(request.getParameter("university")));
				vo.setEmail(request.getParameter("email"));
				vo.setGrade(Integer.parseInt(request.getParameter("grade")));;
				vo.setSemester(Integer.parseInt(request.getParameter("term")));
				vo.setObj_credit(Float.parseFloat(request.getParameter("obj_credit")));
				vo.setGraduate_credit(Integer.parseInt(request.getParameter("graduate_credit")));
				vo.setStu_id((String)session.getAttribute("user_id"));
				if(dao.update(vo)) {
					forward = new ActionForward();
					forward.setPath("myInformation.mem");
					forward.setRedirect(false);
				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('회원정보 변경을 실패하였습니다.'); history.back(-1);</script>");
				}
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원정보 변경을 실패하였습니다.'); history.back(-1);</script>");
			}
		}
		
		return forward;
	}
	
}
