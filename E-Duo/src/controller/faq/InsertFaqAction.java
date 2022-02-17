package controller.faq;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.faq.FAQDAO;
import model.faq.FAQVO;

public class InsertFaqAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FAQDAO dao = new FAQDAO();
		FAQVO vo = new FAQVO();
		vo.setCategory(request.getParameter("category"));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		ActionForward forward = null;
		if(dao.insert(vo) ) {
			forward = new ActionForward();
			forward.setPath("FAQ.jsp");	// 관리자의 FAQ 작성 이후 FAQ목록 페이지로 이동 예정
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('FAQ 작성 중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
