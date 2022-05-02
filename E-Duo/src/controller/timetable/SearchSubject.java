package controller.timetable;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;
import model.subject.SubjectDAO;
import model.subject.SubjectVO;

public class SearchSubject implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubjectDAO dao = new SubjectDAO();
		SubjectVO vo = new SubjectVO();
		vo.setSubject_name(request.getParameter("subject").trim());
		ArrayList<SubjectVO> data = dao.searchSubject(vo);
		System.out.println(data);
		Map<String, SubjectVO> mapData = new HashMap<String, SubjectVO>();
		for(int i = 0; i < data.size(); i++) {
			mapData.put(Integer.toString(data.get(i).getSub_id()), data.get(i));
		}
		Gson gson = new Gson();
		String jsonText = gson.toJson(mapData);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonText);
		return null;
	}
}
