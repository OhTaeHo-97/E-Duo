package controller.faq;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.faq.FAQDAO;
import model.faq.FAQVO;

public class DeleteFAQAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//관리자가 faq를 삭제할 수 있도록 함
		FAQDAO dao = new FAQDAO();
		FAQVO vo = new FAQVO();
		vo.setFaq_id(Integer.parseInt(request.getParameter("fid")));
		ActionForward forward = null;
		
		if(dao.delete(vo)) {
			forward = new ActionForward();
			forward.setPath("selectAllFAQ.faq");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('FAQ 삭제 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		
		return forward;
	}

}
