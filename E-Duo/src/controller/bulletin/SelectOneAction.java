package controller.bulletin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.bulletin.BulletinDAO;
import model.bulletin.BulletinSet;
import model.bulletin.BulletinVO;

public class SelectOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BulletinDAO dao = new BulletinDAO();
		BulletinVO vo = new BulletinVO();
		BulletinSet bul_data = null;
		vo.setBul_id(Integer.parseInt(request.getParameter("bul_id")));
		bul_data = dao.selectOne(vo);
		
		ActionForward forward = null;
		if(bul_data != null) {
			forward = new ActionForward();
			forward.setPath("#");
			forward.setRedirect(false);
		}
		return forward;
	}

}
