package controller.bulletin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

/**
 * Servlet implementation class BulletinFrontController
 */
@WebServlet("*.bul")
public class BulletinFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BulletinFrontController() {
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
		if(command.equals("/deleteBulletin.bul")) {
			try {
				forward = new DeleteBulletinAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("DeleteBulletinAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/deleteReply.bul")) {
			try {
				forward = new DeleteReplyAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("DeleteReplyAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertBulletin.bul")) {
			try {
				forward = new InsertBulletinAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertBulletinAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/insertReply.bul")) {
			try {
				forward = new InsertReplyAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("InsertReplyAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectCategoryFilterAll.bul")) {
			try {
				forward = new SelectCategoryFilterAllAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectCategoryFilterAllAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/searchBulletinByContent_Title.bul")) {
			try {
				forward = new SearchBulletinByContent_TitleAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SearchBulletinByContent_TitleAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/searchBulletinByContent.bul")) {
			try {
				forward = new SearchBulletinByContentAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SearchBulletinByContentAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/searchBulletinByTitle.bul")) {
			try {
				forward = new SearchBulletinByTitleAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SearchBulletinByTitleAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectMyReply.bul")) {
			try {
				forward = new SelectMyReplyAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectMyReplyAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/selectMyText.bul")) {
			try {
				forward = new SelectMyTextAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectMyTextAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/bulletin_detail.bul")) {
			try {
				forward = new SelectOneAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("SelectOneAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/updateBulletin.bul")) {
			try {
				forward = new UpdateBulletinAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("UpdateBulletinAction 수행 중 문제 발생!");
				e.printStackTrace();
			}
		} else if(command.equals("/updateReply.bul")) {
			try {
				forward = new UpdateReplyAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("UpdateReplyAction 수행 중 문제 발생!");
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
