package controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

/**
 * Servlet implementation class NoticeFrontController
 */
@WebServlet("*.notice")
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward = null;
		if(command.equals("/noticePage.notice")) {
			try {
				forward = new GetNoticePageAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetNoticePageAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/noticeDetail.notice")) {
			try {
				forward = new GetNoticeDetailAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetNoticeDetailAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertNotice.notice")) {
			try {
				forward = new InsertNoticeAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertNoticeAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/deleteNotice.notice")) {
			try {
				forward = new DeleteNoticeAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("DeleteNoticeAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/updateNotice.notice")) {
			try {
				forward = new UpdateNoticeAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("UpdateNoticeAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(command);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
