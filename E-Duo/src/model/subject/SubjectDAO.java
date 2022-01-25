package model.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class SubjectDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO subject VALUES(subject_seq.NEXTVAL,?,?,?,?,?,?,?,?)"; 
	private String sql_select = "SELECT * FROM subject WHERE sub_id=?"; 
	private String sql_update = "UPDATE subject SET academic_number=?, subject_name=?, professor=?, credit_num=?, classroom=?, start_time=?, end_time=? WHERE sub_id=?";
	private String sql_delete = "DELETE FROM subject WHERE sub_id=?";
	private String sql_selectAll = "SELECT * FROM bulletin";
	private String sql_selectFilter = "";
	
	public boolean insert(SubjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(1,vo.getAcademic_number());
			pstmt.setInt(2, vo.getUni_id());
			pstmt.setString(3, vo.getSubject_name());
			pstmt.setString(4, vo.getProfessor());
			pstmt.setInt(5, vo.getCredit_num());
			pstmt.setString(6, vo.getClassroom());
			pstmt.setDate(7, vo.getStart_time());
			pstmt.setDate(8, vo.getEnd_time());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Subject Insert문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public SubjectVO selectOne(SubjectVO vo) {
		SubjectVO sub_data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, vo.getSub_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sub_data = new SubjectVO();
				sub_data.setAcademic_number(rs.getInt("academic_number"));
				sub_data.setClassroom(rs.getString("classroom"));
				sub_data.setCredit_num(rs.getInt("credit_num"));
				sub_data.setEnd_time(rs.getDate("end_time"));
				sub_data.setProfessor(rs.getString("professor"));
				sub_data.setStart_time(rs.getDate("start_time"));
				sub_data.setSub_id(rs.getInt("sub_id"));
				sub_data.setSubject_name(rs.getString("subject_name"));
				sub_data.setUni_id(rs.getInt("uni_id"));
				
			}
		} catch (SQLException e) {
			System.out.println("Subject selectOne문 에러 : " + e);
			e.printStackTrace();
		}
		
		return sub_data;
	}
	
	public boolean update(SubjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getAcademic_number());
			pstmt.setString(2, vo.getSubject_name());
			pstmt.setString(3, vo.getProfessor());
			pstmt.setInt(4, vo.getCredit_num());
			pstmt.setString(5, vo.getClassroom());
			pstmt.setDate(6, vo.getStart_time());
			pstmt.setDate(7, vo.getEnd_time());
			pstmt.setInt(8, vo.getSub_id());		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Subject update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public boolean delete(SubjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getSub_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Subject delete문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
}
