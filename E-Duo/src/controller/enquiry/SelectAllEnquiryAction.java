package controller.enquiry;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.enquiry.EnquiryDAO;
import model.enquiry.EnquiryVO;

public class SelectAllEnquiryAction implements Action
{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 관리자가 회원들이 작성한 문의사항 전체를 볼수 있도록 함
		EnquiryDAO dao = new EnquiryDAO();
		ArrayList<EnquiryVO> enq_datas = new ArrayList<EnquiryVO>();
		enq_datas = dao.selectAll();
		ActionForward forward = null;
		if(enq_datas.size() != 0) {
			request.setAttribute("enq_datas", enq_datas);
			forward = new ActionForward();
			forward.setPath("#"); 	// 관리자가 문의사항 전체보기 페이지로 갈 예정
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터를 불러오는 도중 문제가 발생하였습니다.'); history.back(-1);</script>");
		}
		return forward;
	}
	
}