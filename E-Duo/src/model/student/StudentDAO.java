package model.student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.common.JDBCUtil;

public class StudentDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	private String sql_select = "SELECT * FROM student WHERE stu_id=?"; 
	private String sql_update = "UPDATE student SET name=?, cellphone=?, postcode=?, address=?, detail_address=?, "
			+ "reference=?, uni_id=?, email=?, grade=?, semester=?, obj_credit=?, graduate_credit=? WHERE stu_id = ?";   
	private String sql_delete = "DELETE FROM member WHERE mid=? AND mpw=?";
	
	public boolean insert(StudentVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getStu_id());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getCellphone());
			pstmt.setInt(4, vo.getPostcode());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getDetail_address());
			pstmt.setString(7, vo.getRefernece());
			pstmt.setInt(8, vo.getUni_id());
			pstmt.setString(9, vo.getEmail());
			pstmt.setString(10, vo.getGender());
			SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date birth = new Date(dtFormat.parse(vo.getBirth()).getTime());
			pstmt.setDate(11, birth);
			pstmt.setInt(12, vo.getGrade());
			pstmt.setInt(13, vo.getSemester());
			pstmt.setFloat(14, vo.getObj_credit());
			pstmt.setInt(15, vo.getGraduate_credit());
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
				stu_data.setName(rs.getString("name"));
				stu_data.setCellphone(rs.getString("cellphone"));
				stu_data.setAddress(rs.getString("address"));
				stu_data.setDetail_address(rs.getString("detail_address"));
				stu_data.setRefernece(rs.getString("reference"));
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
			pstmt.setString(13, vo.getStu_id());
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
