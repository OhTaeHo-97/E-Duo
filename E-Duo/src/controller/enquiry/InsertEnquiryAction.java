package controller.enquiry;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.enquiry.EnquiryDAO;
import model.enquiry.EnquiryVO;

public class InsertEnquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EnquiryDAO dao = new EnquiryDAO();
		EnquiryVO vo = new EnquiryVO();
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		ActionForward forward = null;
		if(dao.insert(vo) ) {
			forward = new ActionForward();
			forward.setPath("#");	// 문의사항 작성 후 main페이지로 가던지, 다시 문의사항 페이지로 오던지 결정해야함
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('문의사항 작성 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
