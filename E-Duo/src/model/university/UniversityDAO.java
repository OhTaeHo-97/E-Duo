package model.university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class UniversityDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO university VALUES(?,?)"; 
	private String sql_select = "SELECT * FROM university WHERE uni_id=?";
	private String sql_selectUniv = "SELECT * FROM uni_id WHERE uni_name=?"; 
	private String sql_update = "UPDATE university SET uni_id=?, uni_name=? WHERE uni_id=?";
	private String sql_delete = "DELETE FROM university WHERE uni_id=?";
	private String sql_selectAll = "SELECT * FROM university";	
	private String sql_selectFilter = "";
	
	public boolean insert(UniversityVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(1, vo.getUni_id());
			pstmt.setString(2, vo.getUni_name());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("University insert문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result == 1;
	}
	
	public UniversityVO selectOne(UniversityVO vo) {
		UniversityVO uni_data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, vo.getUni_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				uni_data = new UniversityVO();
				uni_data.setUni_id(rs.getInt("uni_id"));
				uni_data.setUni_name(rs.getString("uni_name"));
			}
		} catch (SQLException e) {
			System.out.println("University selectOne문 에러 : " + e);
			e.printStackTrace();
		}
		
		return uni_data;
	}
	
	public boolean update(UniversityVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getUni_id());
			pstmt.setString(2, vo.getUni_name());
			pstmt.setInt(3, vo.getUni_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("University update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public boolean delete(UniversityVO vo) {
		int result = 0;
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getUni_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("University delete문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public ArrayList<UniversityVO> selectAll() {
		ArrayList<UniversityVO> uni_datas = new ArrayList<UniversityVO>();
		UniversityVO uni_data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uni_data = new UniversityVO();
				uni_data.setUni_id(rs.getInt("uni_id"));
				uni_data.setUni_name(rs.getString("uni_name"));
				uni_datas.add(uni_data);
			}
		} catch (SQLException e) {
			System.out.println("University selectAll문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return uni_datas;
	}
	
	public UniversityVO selectUniv(UniversityVO vo) {
		UniversityVO uni_data = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectUniv);
			pstmt.setInt(1, vo.getUni_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				uni_data = new UniversityVO();
				uni_data.setUni_id(rs.getInt("uni_id"));
				uni_data.setUni_name(rs.getString("uni_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("University selectUniv문 에러 : " + e);
			e.printStackTrace();
		}
		return uni_data;
	}
}
