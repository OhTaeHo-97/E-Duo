package controller.faq;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.faq.FAQDAO;
import model.faq.FAQVO;

public class UpdateFAQAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FAQDAO dao = new FAQDAO();
		FAQVO vo = new FAQVO();
		System.out.println(request.getParameter("category"));
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setFaq_id(Integer.parseInt(request.getParameter("fid")));
		vo.setTitle(request.getParameter("title"));
		
		ActionForward forward = null;
		if(dao.update(vo)) {
			forward = new ActionForward();
			forward.setPath("selectAllFAQ.faq");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('FAQ 작성 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
