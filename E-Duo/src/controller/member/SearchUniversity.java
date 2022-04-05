package controller.member;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;
import model.university.UniversityDAO;
import model.university.UniversityVO;

public class SearchUniversity implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UniversityDAO dao = new UniversityDAO();
		UniversityVO vo = new UniversityVO();
		vo.setUni_name(request.getParameter("university").trim());
		ArrayList<UniversityVO> data = dao.searchUniversity(vo);
		System.out.println(data.size());
		Map<String, String> mapData = new HashMap<String, String>();
		for(int i = 0; i < data.size(); i++) {
			mapData.put(Integer.toString(data.get(i).getUni_id()), data.get(i).getUni_name());
		}
		Gson gson = new Gson();
		String jsonText = gson.toJson(mapData);
		response.setCharacterEncoding("UTF-8"); // return 하기 전에 인코딩 타입 지정해줌으로서 한글 깨짐 해
		PrintWriter out = response.getWriter();
		out.print(jsonText);
		return null;
	}
}
