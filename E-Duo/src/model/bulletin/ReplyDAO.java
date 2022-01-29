package model.bulletin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO reply VALUES (select nvl(MAX(rep_id),0)+1,?,?,?,?)";  
	private String sql_update = "UPDATE reply SET content=?, regDate=? WHERE rep_id=?";
	private String sql_delete = "DELETE FROM reply WHERE rep_id=?";
	private String sql_selectAll = "SELECT * FROM reply";
	private String sql_selectMyReply = "SELECT * FROM reply WHERE stu_id = ?";
	
	public boolean insert(ReplyVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getStu_id());
			pstmt.setInt(2, vo.getBul_id());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getRegDate());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Reply insert문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result == 1;
	}
	
	public boolean update(ReplyVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getRegDate());
			pstmt.setInt(3, vo.getRep_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Reply update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result == 1;
		
	}
	
	public boolean delete(ReplyVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getRep_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Reply delete문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result == 1;
	}
	
	public ArrayList<ReplyVO> selectAll() {
		ArrayList<ReplyVO> rep_datas = new ArrayList<ReplyVO>();
		ReplyVO rep_data = null;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rep_data = new ReplyVO();
				rep_data.setBul_id(rs.getInt("bul_id"));
				rep_data.setContent(rs.getString("content"));
				rep_data.setRegDate(rs.getString("regDate"));
				rep_data.setRep_id(rs.getInt("rep_id"));
				rep_data.setStu_id(rs.getString("stu_id"));
				rep_datas.add(rep_data);
			}
		} catch (SQLException e) {
			System.out.println("Reply selectAll문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return rep_datas;
	}
	
	public ArrayList<ReplyVO> selectMyReply(ReplyVO vo) {
		conn = JDBCUtil.connect();
		ArrayList<ReplyVO> datas = new ArrayList<ReplyVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectMyReply);
			pstmt.setString(1, vo.getStu_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO data = new ReplyVO();
				data.setBul_id(rs.getInt("bul_id"));
				data.setContent(rs.getString("content"));
				data.setRegDate(rs.getString("regDate"));
				data.setRep_id(rs.getInt("rep_id"));
				data.setStu_id(rs.getString("stu_id"));
				
				datas.add(data);
			}
		} catch (SQLException e) {
			System.out.println("ReplyDAO selectMyReply문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return datas;
	}
}