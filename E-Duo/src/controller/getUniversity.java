package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.common.JDBCUtil;

public class getUniversity {
	static Connection conn;
	static PreparedStatement pstmt;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("https://www.career.go.kr/cnet/openapi/getOpenApi.json?apiKey=1a396240224c5055bf2b832adf1560c0&svcType=api&svcCode=SCHOOL&contentType=json&gubun=univ_list&perPage=10000000");
		try {
			URL url = new URL(sb.toString());
			URLConnection connection;
			connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader input = new InputStreamReader(is);
			Stream<String> streamOfString = new BufferedReader(input).lines();
			String universities = streamOfString.collect(Collectors.joining());
			JSONParser parser = new JSONParser();
			JSONObject jObject = (JSONObject)parser.parse(universities);
			JSONArray jArray = (JSONArray)((JSONObject)jObject.get("dataSearch")).get("content");
			String insertUniversity = "insert into university values(?, ?)";
			conn = JDBCUtil.connect();
			for(int i = 0; i < jArray.size(); i++) {
				JSONObject tempObj = (JSONObject)jArray.get(i);
				String campusName = (String)tempObj.get("campusName");
				String schoolName = (String)tempObj.get("schoolName");
				StringTokenizer st = new StringTokenizer(schoolName);
				schoolName = st.nextToken();
				pstmt = conn.prepareStatement(insertUniversity);
				pstmt.setInt(1, i + 1);
				pstmt.setString(2, schoolName + " " + campusName);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
}
