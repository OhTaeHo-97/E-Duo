package controller.credit_manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import controller.enquiry.DeleteEnquiryAction;
import controller.enquiry.InsertEnquiryAction;

/**
 * Servlet implementation class Credit_manageFrontController
 */
@WebServlet("*.cre")
public class Credit_manageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Credit_manageFrontController() {
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
		
		if(command.equals("/showCreditManage.cre")) {
			try {
				forward = new ShowCreditManageAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("ShowCreditManageAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertEnquiry.enq")) {
			try {
				forward = new InsertEnquiryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertEnquiryAction 수행 중 문제 발생!");
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
