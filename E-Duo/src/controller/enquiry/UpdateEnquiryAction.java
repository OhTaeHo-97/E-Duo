package controller.enquiry;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.enquiry.EnquiryDAO;
import model.enquiry.EnquiryVO;

public class UpdateEnquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 문의사항 수정인데, 필요할 지 유무는 대화 필요
		EnquiryDAO dao = new EnquiryDAO();
		EnquiryVO vo = new EnquiryVO();
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setEid(Integer.parseInt(request.getParameter("eid")));
		vo.setTitle(request.getParameter("title"));
		
		ActionForward forward = null;
		if(dao.update(vo) ) {
			forward = new ActionForward();
			forward.setPath("#");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('문의사항 수정 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return null;
	}

}
