package controller.enquiry;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.enquiry.EnquiryDAO;
import model.enquiry.EnquiryVO;

public class DeleteEnquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 관리지가 문의사항을 해결한 후에 DB에서 삭제하기 위한 Controller
		EnquiryDAO dao = new EnquiryDAO();
		EnquiryVO vo = new EnquiryVO();
		vo.setEnq_id(Integer.parseInt(request.getParameter("eid")));
		
		ActionForward forward = null;
		if(dao.delete(vo)) {
			forward = new ActionForward();
			forward.setPath("#"); // 경로 생각
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('문의사항 삭제 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}
}
