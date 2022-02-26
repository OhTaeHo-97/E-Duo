package controller.faq;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.faq.FAQDAO;
import model.faq.FAQVO;

public class SearchFAQByContent_TitleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 제목 or 내용을 통하여 FAQ를 검색할 수 있도록 함
		FAQDAO dao = new FAQDAO();
		FAQVO vo = new FAQVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCategory(request.getParameter("content"));
		ArrayList<FAQVO> faq_datas = dao.searchFAQByContent_Title(vo);
		
		ActionForward forward = null;
		if(faq_datas.size() != 0) {
			request.setAttribute("faq_datas", faq_datas);
			forward = new ActionForward();
			forward.setPath("FAQ.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('조건을 만족하는 데이터가 존재하지 않습니다.'); history.back(-1);</script>");
		}
		return forward;
	}

}
