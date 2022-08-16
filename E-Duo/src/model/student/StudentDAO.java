package model.student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.common.JDBCUtil;

public class StudentDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	private String sql_select = "SELECT * FROM student WHERE stu_id=?"; 
//	private String sql_update = "UPDATE student SET name=?, cellphone=?, postcode=?, address=?, detail_address=?, "
//			+ "reference=?, uni_id=?, email=?, grade=?, semester=?, obj_credit=?, graduate_credit=?, nickname=? WHERE stu_id = ?";
//	private String sql_update = "UPDATE student SET s_name=?, cellphone=?, postcode=?, address=?, detail_address=?, "
//			+ "reference=?, uni_id=?, email=?, grade=?, semester=?, obj_credit=?, graduate_credit=?, nickname=? WHERE stu_id = ?";
	private String sql_update = "UPDATE student SET s_name=?, cellphone=?, postcode=?, address=?, detail_address=?, "
			+ "ref=?, uni_id=?, email=?, grade=?, semester=?, obj_credit=?, graduate_credit=?, nickname=? WHERE stu_id = ?";
	private String sql_delete = "DELETE FROM member WHERE mid=? AND mpw=?";
	private String sql_checkNickname = "SELECT * FROM student WHERE nickname=?";
	private String sql_update_obj_credit = "UPDATE student SET obj_credit=? where stu_id = ?";
	
	public boolean insert(StudentVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getStu_id());
			System.out.println(vo.getName());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getCellphone());
			pstmt.setInt(5, vo.getPostcode());
			pstmt.setString(6, vo.getAddress());
			pstmt.setString(7, vo.getDetail_address());
			pstmt.setString(8, vo.getRefernece());
			pstmt.setInt(9, vo.getUni_id());
			pstmt.setString(10, vo.getEmail());
			pstmt.setString(11, vo.getGender());
			SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date birth = new Date(dtFormat.parse(vo.getBirth()).getTime());
			pstmt.setDate(12, birth);
			pstmt.setInt(13, vo.getGrade());
			pstmt.setInt(14, vo.getSemester());
			pstmt.setFloat(15, vo.getObj_credit());
			pstmt.setInt(16, vo.getGraduate_credit());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Student Insert문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public StudentVO selectOne(StudentVO vo) {
		StudentVO stu_data = null;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, vo.getStu_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				stu_data = new StudentVO();
				stu_data.setStu_id(rs.getString("stu_id"));
//				stu_data.setName(rs.getString("name"));
				stu_data.setName(rs.getString("s_name"));
				stu_data.setNickname(rs.getString("nickname"));
				stu_data.setCellphone(rs.getString("cellphone"));
				stu_data.setPostcode(rs.getInt("postcode"));
				stu_data.setAddress(rs.getString("address"));
				stu_data.setDetail_address(rs.getString("detail_address"));
//				stu_data.setRefernece(rs.getString("reference"));
				stu_data.setRefernece(rs.getString("ref"));
				stu_data.setUni_id(rs.getInt("uni_id"));
				stu_data.setEmail(rs.getString("email"));
				stu_data.setGender(rs.getString("gender"));
				stu_data.setBirth(rs.getString("birth"));
				stu_data.setGrade(rs.getInt("grade"));
				stu_data.setSemester(rs.getInt("semester"));
				stu_data.setObj_credit(rs.getFloat("obj_credit"));
				stu_data.setGraduate_credit(rs.getInt("graduate_credit"));
			}
		} catch (SQLException e) {
			System.out.println("Student Select문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return stu_data;
	}
	
	public boolean update(StudentVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getCellphone());
			pstmt.setInt(3, vo.getPostcode());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getDetail_address());
			pstmt.setString(6, vo.getRefernece());
			pstmt.setInt(7, vo.getUni_id());
			pstmt.setString(8, vo.getEmail());
			pstmt.setInt(9, vo.getGrade());
			pstmt.setInt(10, vo.getSemester());
			pstmt.setFloat(11, vo.getObj_credit());
			pstmt.setInt(12, vo.getGraduate_credit());
			pstmt.setString(13, vo.getNickname());
			pstmt.setString(14, vo.getStu_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Student Update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public int checkNickname(StudentVO vo) { // 닉네임 중복검사 : 버튼클릭해서 중복여부 확인
		int usable = 0;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_checkNickname);
			//select * from member where member_id = ?
			pstmt.setString(1, vo.getNickname());
			rs = pstmt.executeQuery();
			System.out.println("usable: " + usable);
			if(rs.next()) { // 존재한다면?? false값 반환
				usable = 0;
			}
			else {			// 존재안한다면?? true값 반환
				usable = 1;
			}
			
		} catch (SQLException e) {
			System.out.println("StudentDAO checkNickname진행 중 오류");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return usable;
	}
	
	public boolean update_obj_credit(StudentVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setFloat(1, vo.getObj_credit());
			pstmt.setString(2, vo.getStu_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Student Update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
/*	public boolean delete() {		//인자로 login_info를 받을 예정
		int result = 0;
		
	}*/
}
