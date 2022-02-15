package model.my_subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.university.UniversityVO;

public class My_subjectDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO my_subject VALUES(?,?,?,?,?,?)"; 
	private String sql_select = "SELECT * FROM my_subject WHERE my_sub_id=?"; 
	private String sql_update = "UPDATE my_subject SET academic_number=?, credit=?, grade=?, semester=? WHERE my_sub_id=?";
	private String sql_delete = "DELETE FROM my_subject WHERE my_sub_id=?";
	private String sql_selectAllMy_subject = "SELECT * FROM my_subject where stu_id=?";	
	private String sql_selectFilterBySemester = "SELECT * FROM my_subject WHERE stu_id=? and grade=? and semester=?";
	
	public boolean insert(My_subjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(1, vo.getMy_sub_id());
			pstmt.setInt(2, vo.getAcademic_number());
			pstmt.setString(3, vo.getStu_id());
			pstmt.setFloat(4, vo.getCredit());
			pstmt.setInt(5, vo.getGrade());
			pstmt.setInt(6, vo.getSemester());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("My_subject insert문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result == 1;
	}
	
	public My_subjectVO selectOne(My_subjectVO vo) {
		My_subjectVO my_sub_data = null;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, vo.getMy_sub_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				my_sub_data = new My_subjectVO();
				my_sub_data.setAcademic_number(rs.getInt("academic_number"));
				my_sub_data.setCredit(rs.getFloat("credit"));
				my_sub_data.setGrade(rs.getInt("grade"));
				my_sub_data.setMy_sub_id(rs.getInt("my_sub_id"));
				my_sub_data.setSemester(rs.getInt("semester"));
				my_sub_data.setStu_id(rs.getString("stu_id"));
			}
		} catch (SQLException e) {
			System.out.println("My_subject selectOne문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return my_sub_data;
	}
	
	public boolean update(My_subjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getAcademic_number());
			pstmt.setFloat(2, vo.getCredit());
			pstmt.setInt(3, vo.getGrade());
			pstmt.setInt(4, vo.getSemester());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("My_subject update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	public boolean delete(My_subjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getMy_sub_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("My_subject delete문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	public ArrayList<My_subjectVO> selectAllMy_subject(My_subjectVO vo) {
		ArrayList<My_subjectVO> my_sub_datas = new ArrayList<My_subjectVO>();
		My_subjectVO my_sub_data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAllMy_subject);
			pstmt.setString(1, vo.getStu_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				my_sub_data = new My_subjectVO();
				my_sub_data.setAcademic_number(rs.getInt("academic_number"));
				my_sub_data.setCredit(rs.getFloat("credit"));
				my_sub_data.setGrade(rs.getInt("grade"));
				my_sub_data.setMy_sub_id(rs.getInt("my_sub_id"));
				my_sub_data.setSemester(rs.getInt("semester"));
				my_sub_data.setStu_id(rs.getString("stu_id"));
				my_sub_datas.add(my_sub_data);
			}
		} catch (SQLException e) {
			System.out.println("My_subject selectAll문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return my_sub_datas;
	}
	// private String sql_selectFilterBySemester = "SELECT * FROM my_subject WHERE stu_id=? and grade=? and semester=?";
	public ArrayList<My_subjectVO> selectFilterBySemester(My_subjectVO vo) {
		ArrayList<My_subjectVO> my_sub_datas = new ArrayList<My_subjectVO>();
		My_subjectVO my_sub_data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectFilterBySemester);
			pstmt.setString(1, vo.getStu_id());
			pstmt.setInt(2, vo.getGrade());
			pstmt.setInt(3, vo.getSemester());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				my_sub_data = new My_subjectVO();
				my_sub_data.setAcademic_number(rs.getInt("academic_number"));
				my_sub_data.setCredit(rs.getFloat("credit"));
				my_sub_data.setGrade(rs.getInt("grade"));
				my_sub_data.setMy_sub_id(rs.getInt("my_sub_id"));
				my_sub_data.setSemester(rs.getInt("semester"));
				my_sub_data.setStu_id(rs.getString("stu_id"));
				my_sub_datas.add(my_sub_data);
			}
		} catch (SQLException e) {
			System.out.println("My_subject selectFilter문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return my_sub_datas;
	}
}
