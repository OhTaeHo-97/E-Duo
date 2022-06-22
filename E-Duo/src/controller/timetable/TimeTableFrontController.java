package controller.timetable;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

/**
 * Servlet implementation class TimeTableFrontController
 */
@WebServlet("*.timetable")
public class TimeTableFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeTableFrontController() {
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
		if(command.equals("/timetablePage.timetable")) {
			try {
				forward = new GetTimeTableAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetTimeTableAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/subjectInfo.timetable")) {
			try {
				forward = new GetSubjectAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("GetSubjectAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertTimeTable.timetable")) {
			try {
				forward = new InsertTimeTableAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertTimeTableAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/getSubjects.timetable")) {
			try {
				forward = new SearchSubject().execute(request, response);
			} catch (Exception e) {
				System.out.println("SearchSubject() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertSubject.timetable")) {
			try {
				forward = new InsertSubjectAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertSubjectAction() 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/removeSubject.timetable")) {
			try {
				forward = new RemoveSubjectAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("RemoveSubjectAction() 수행 중 문제 발생!");
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
