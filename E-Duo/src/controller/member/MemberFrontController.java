package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.mem")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward = null;
		if(command.equals("/login.mem")) {
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("LoginAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/logout.mem")) {
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("LogoutAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/deleteStudent.mem")) {
			try {
				forward = new DeleteStudentAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("DeleteStudentAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/editMyInfo.mem")) {
			try {
				forward = new EditMyInformationAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("EditMyInformationAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/myBulletin.mem")) {
			try {
				forward = new GetMyBulletinAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetMyBulletinAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/myReply.mem")) {
			try {
				forward = new GetMyReplyAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetMyReplyAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/myInfo.mem")) {
			try {
				forward = new GetMyInformationAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetMyInformationAction 수행 중 문제 발생!");
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
