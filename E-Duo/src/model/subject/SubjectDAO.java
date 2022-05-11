package model.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class SubjectDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO subject VALUES((select NVL(MAX(sub_id), 0) + 1 from subject),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String sql_select = "SELECT * FROM subject WHERE sub_id=?"; 
	private String sql_update = "UPDATE subject SET academic_number=?, subject_name=?, professor=?, credit_num=?, classroom=?, first_date=?, first_start=?, first_end=?, second_date=?, second_start=?, second_end=?, third_date=?, third_start=?, third_end=? WHERE sub_id=?";
	private String sql_delete = "DELETE FROM subject WHERE sub_id=?";
	private String sql_selectAll = "SELECT * FROM subject WHERE uni_id=?";
	private String sql_searchSubject = "SELECT * FROM subject WHERE subject_name LIKE '%'||?||'%'"; // 오라클
//	private String sql_searchSubject = "SELECT * FROM lecture WHERE subject_name LIKE ?"; // MySQL
	
	public boolean insert(SubjectVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1,vo.getAcademic_number());
			pstmt.setInt(2, vo.getUni_id());
			pstmt.setString(3, vo.getSubject_name());
			pstmt.setString(4, vo.getProfessor());
			pstmt.setInt(5, vo.getCredit_num());
			pstmt.setString(6, vo.getClassroom());
			pstmt.setString(7, vo.getSub_sort());
			pstmt.setString(8, vo.getMajor());
			pstmt.setString(9, vo.getFirst_date());
			pstmt.setString(10, vo.getFirst_start());
			pstmt.setString(11, vo.getFirst_end());
			pstmt.setString(12, vo.getSecond_date());
			pstmt.setString(13, vo.getSecond_start());
			pstmt.setString(14, vo.getSecond_end());
			pstmt.setString(15, vo.getThird_date());
			pstmt.setString(16, vo.getThird_start());
			pstmt.setString(17, vo.getThird_end());
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
				sub_data.setAcademic_number(rs.getString("academic_number"));
				sub_data.setUni_id(rs.getInt("uni_id"));
				sub_data.setSubject_name(rs.getString("subject_name"));
				sub_data.setProfessor(rs.getString("professor"));
				sub_data.setCredit_num(rs.getInt("credit_num"));
				sub_data.setClassroom(rs.getString("classroom"));
				sub_data.setSub_sort(rs.getString("sub_sort"));
				sub_data.setMajor(rs.getString("major"));
				sub_data.setFirst_date(rs.getString("first_date"));
				sub_data.setFirst_start(rs.getString("first_start"));
				sub_data.setFirst_end(rs.getString("first_end"));
				sub_data.setSecond_date(rs.getString("second_date"));
				sub_data.setSecond_start(rs.getString("second_start"));
				sub_data.setSecond_end(rs.getString("second_end"));
				sub_data.setThird_date(rs.getString("third_date"));
				sub_data.setThird_start(rs.getString("third_start"));
				sub_data.setThird_end(rs.getString("third_end"));
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
			pstmt.setString(1, vo.getAcademic_number());
			pstmt.setString(2, vo.getSubject_name());
			pstmt.setString(3, vo.getProfessor());
			pstmt.setInt(4, vo.getCredit_num());
			pstmt.setString(5, vo.getClassroom());
			pstmt.setString(6, vo.getFirst_date());
			pstmt.setString(7, vo.getFirst_start());
			pstmt.setString(8, vo.getFirst_end());
			pstmt.setString(9, vo.getSecond_date());
			pstmt.setString(10, vo.getSecond_start());
			pstmt.setString(11, vo.getSecond_end());
			pstmt.setString(12, vo.getThird_date());
			pstmt.setString(13, vo.getThird_start());
			pstmt.setString(14, vo.getThird_end());
			pstmt.setInt(15, vo.getSub_id());
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
	
	public ArrayList<SubjectVO> selectAll(SubjectVO vo) {
		ArrayList<SubjectVO> sub_datas = new ArrayList<SubjectVO>();
		SubjectVO sub_data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setInt(1, vo.getUni_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sub_data = new SubjectVO();
				sub_data.setAcademic_number(rs.getString("academic_number"));
				sub_data.setUni_id(rs.getInt("uni_id"));
				sub_data.setSubject_name(rs.getString("subject_name"));
				sub_data.setProfessor(rs.getString("professor"));
				sub_data.setCredit_num(rs.getInt("credit_num"));
				sub_data.setClassroom(rs.getString("classroom"));
				sub_data.setSub_sort(rs.getString("sub_sort"));
				sub_data.setMajor(rs.getString("major"));
				sub_data.setFirst_date(rs.getString("first_date"));
				sub_data.setFirst_start(rs.getString("first_start"));
				sub_data.setFirst_end(rs.getString("first_end"));
				sub_data.setSecond_date(rs.getString("second_date"));
				sub_data.setSecond_start(rs.getString("second_start"));
				sub_data.setSecond_end(rs.getString("second_end"));
				sub_data.setThird_date(rs.getString("third_date"));
				sub_data.setThird_start(rs.getString("third_start"));
				sub_data.setThird_end(rs.getString("third_end"));
				sub_datas.add(sub_data);
			}
		} catch (SQLException e) {
			System.out.println("Subject selectAll문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return sub_datas;
	}
	
	public ArrayList<SubjectVO> searchSubject(SubjectVO vo) {
		ArrayList<SubjectVO> data = new ArrayList<SubjectVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_searchSubject);
			System.out.println(vo.getSubject_name());
//			pstmt.setString(1, vo.getSubject_name()); // 오라클
			pstmt.setString(1, "%" + vo.getSubject_name() + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SubjectVO svo = new SubjectVO();
				svo.setSub_id(rs.getInt("sub_id"));
				svo.setAcademic_number(rs.getString("academic_number"));
				svo.setSubject_name(rs.getString("subject_name"));
				svo.setSub_sort(rs.getString("sub_sort"));
				svo.setMajor(rs.getString("major"));
				svo.setCredit_num(rs.getInt("credit_num"));
				svo.setProfessor(rs.getString("professor"));
				svo.setFirst_date(rs.getString("first_date"));
				svo.setFirst_start(rs.getString("first_start"));
				svo.setFirst_end(rs.getString("first_end"));
				svo.setSecond_date(rs.getString("second_date"));
				svo.setSecond_start(rs.getString("second_start"));
				svo.setSecond_end(rs.getString("second_end"));
				svo.setThird_date(rs.getString("third_date"));
				svo.setThird_start(rs.getString("third_start"));
				svo.setThird_end(rs.getString("third_end"));
				svo.setClassroom(rs.getString("classroom"));
				data.add(svo);
			}
		} catch (SQLException e) {
			System.out.println("Subject searchSubject문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
}
