package controller.faq;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.faq.FAQDAO;
import model.faq.FAQVO;

public class GetFAQEditPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FAQDAO dao = new FAQDAO();
		FAQVO vo = new FAQVO();
		vo.setFaq_id(Integer.parseInt(request.getParameter("fid")));
		FAQVO faq_data = dao.selectOne(vo);
		
		ActionForward forward = null;
		if(faq_data != null) {
			request.setAttribute("faq_data", faq_data);
			forward = new ActionForward();
			forward.setPath("FAQEdit.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
