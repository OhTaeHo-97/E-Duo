package model.faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class FAQDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_selectAll = "select * from FAQ";
	private String sql_selectOne = "select * from FAQ where fid = ?";
	private String sql_insert = "insert into FAQ values((select nvl(max(fid), 0) + 1 from FAQ), ?, ?, ?)";
	private String sql_delete = "delete from FAQ where fid = ?";
	private String sql_update = "update FAQ set category = ?, title = ?, content = ? where fid = ?";
	
	public ArrayList<FAQVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<FAQVO> datas = new ArrayList<FAQVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FAQVO vo = new FAQVO();
				vo.setCategory(rs.getString("category"));
				vo.setContent(rs.getString("content"));
				vo.setFid(rs.getInt("fid"));
				vo.setTitle(rs.getString("title"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("FAQDAO selectAll() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public FAQVO selectOne(FAQVO vo) {
		conn = JDBCUtil.connect();
		FAQVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getFid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new FAQVO();
				data.setCategory(rs.getString("category"));
				data.setContent(rs.getString("content"));
				data.setFid(rs.getInt("fid"));
				data.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("FAQDAO selectAll() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(FAQVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("FAQDAO insert() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean delete(FAQVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getFid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("FAQDAO delete() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean update(FAQVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getFid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("FAQDAO update() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
