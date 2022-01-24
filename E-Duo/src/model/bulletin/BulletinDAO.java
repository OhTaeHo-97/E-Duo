package model.bulletin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BulletinDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insert = "INSERT INTO bulletin(bul_id, stu_id, category, title, content, image, regdate)"
			+ "VALUES"
			+ "(bulletin_seq.NEXTVAL,?,?,?,?,?,?)"; 
	private String sql_select = "SELECT * FROM member WHERE bul_id=?"; 
	private String sql_update = "UPDATE bulletin SET category=?, title=?, content=?, image=?, regdate=? WHERE bul_id=?";
	private String sql_delete = "DELETE FROM bulletin WHERE bul_id=?";
	private String sql_selectAll = "SELECT * FROM bulletin";
	
	public boolean insert(BulletinVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getStu_id());
			pstmt.setString(2, vo.getCategory());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getImage());
			pstmt.setString(6, vo.getRegdate());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Bulletin Update문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result == 1;
	}
	
	public ArrayList<BulletinVO> selectAll() {
		ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
		BulletinVO bdata = null;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bdata = new BulletinVO();
				bdata.setBul_id(rs.getInt("bul_id"));
				bdata.setCategory(rs.getString("category"));
				bdata.setContent(rs.getString("content"));
				bdata.setImage(rs.getString("image"));
				bdata.setRegdate(rs.getString("regdate"));
				bdata.setStu_id(rs.getString("stu_id"));
				bdata.setTitle(rs.getString("title"));
				
				bul_datas.add(bdata);
			}
		} catch (SQLException e) {
			System.out.println("Bulletin SelectAll문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return bul_datas;
		
	}
	
	public BulletinVO selectOne(BulletinVO vo) {	// 수정 필요, 한 개의 게시물을 눌렀을 경우 reply들이 보이도록 해야 함 reply와 연동 후 수정
		BulletinVO bdata = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, vo.getBul_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdata = new BulletinVO();
				bdata.setBul_id(rs.getInt("bul_id"));
				bdata.setCategory(rs.getString("category"));
				bdata.setContent(rs.getString("content"));
				bdata.setImage(rs.getString("image"));
				bdata.setRegdate(rs.getString("regdate"));
				bdata.setStu_id(rs.getString("stu_id"));
				bdata.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("Bulletin Select문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return bdata;
	}
	
	public boolean delete(BulletinVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getBul_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Bulletin Delete문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result == 1;
	}
	
	public boolean update(BulletinVO vo) {
		int result = 0;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getBul_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Bulletin Update문 에러 : " + e);
			e.printStackTrace();
		}
		
		return true;
	}
	
}
