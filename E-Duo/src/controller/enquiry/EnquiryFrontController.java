package controller.enquiry;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

/**
 * Servlet implementation class EnquiryFrontController
 */
@WebServlet("*.enq")
public class EnquiryFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquiryFrontController() {
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
		if(command.equals("/deleteEnquiry.enq")) {
			try {
				forward = new DeleteEnquiryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("DeleteEnquiryAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertEnquiry.enq")) {
			try {
				forward = new InsertEnquiryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertEnquiryAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectAllEnquiry.enq")) {
			try {
				forward = new SelectAllEnquiryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectAllEnquiryAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectEnquiry.enq")) {
			try {
				forward = new SelectEnquiryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectEnquiryAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/updateEnquiry.enq")) {
			try {
				forward = new UpdateEnquiryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("UpdateEnquiryAction 수행 중 문제 발생!");
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
