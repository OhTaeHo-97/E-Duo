package controller.faq;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.faq.FAQDAO;
import model.faq.FAQVO;

public class SelectAllFAQAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FAQDAO dao = new FAQDAO();
		ArrayList<FAQVO> faq_datas = new ArrayList<FAQVO>();
		faq_datas = dao.selectAll();
		ActionForward forward = null;
		request.setAttribute("faq_datas", faq_datas);
		forward = new ActionForward();
		forward.setPath("FAQ.jsp");
		forward.setRedirect(false);
//		if(faq_datas.size() != 0) {
//			request.setAttribute("faq_datas", faq_datas);
//			forward = new ActionForward();
//			forward.setPath("FAQ.jsp");
//			forward.setRedirect(false);
//		} else {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('현재 등록된 FAQ가 없습니다.'); history.back(-1);</script>");
//		}
		return forward;
	}

}
