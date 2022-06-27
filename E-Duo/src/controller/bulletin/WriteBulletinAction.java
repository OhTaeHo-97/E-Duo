package controller.bulletin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinSet;
import model.bulletin.BulletinVO;

public class WriteBulletinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setAttribute("category", request.getParameter("category"));
		forward = new ActionForward();
		forward.setPath("bulletin_write.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
