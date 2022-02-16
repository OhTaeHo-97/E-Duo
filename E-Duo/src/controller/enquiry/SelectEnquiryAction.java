package controller.enquiry;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.enquiry.EnquiryDAO;
import model.enquiry.EnquiryVO;

public class SelectEnquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EnquiryDAO dao = new EnquiryDAO();
		EnquiryVO vo = new EnquiryVO();
		EnquiryVO enq_data = null;
		vo.setEid(Integer.parseInt(request.getParameter("eid")));
		enq_data = dao.selectOne(vo);
		
		ActionForward forward = null;
		
		if(enq_data != null) {
			request.setAttribute("enq_data", enq_data);
			forward = new ActionForward();
			forward.setPath("#"); 	// 문의사항 세부 보기 페이지로 이동 아직 존재하지 않음
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글을 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}