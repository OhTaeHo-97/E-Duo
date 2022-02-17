package controller.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
/**
 * Servlet implementation class FAQFrontController
 */
@WebServlet("*.faq")
public class FAQFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward = null;
		if(command.equals("/deleteFAQ.faq")) {
			try {
				forward = new DeleteFAQAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("DeleteFAQAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertFAQ.faq")) {
			try {
				forward = new InsertFAQAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertFAQAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/searchFAQ.faq")) {
			try {
				forward = new SearchFAQAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SearchFAQAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectAllFAQ.faq")) {
			try {
				forward = new SelectAllFAQAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectAllFAQAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectOneFAQ.faq")) {
			try {
				forward = new SelectOneFAQAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectOneFAQAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/updateFAQ.faq")) {
			try {
				forward = new UpdateFAQAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("UpdateFAQAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} 
	}
}
