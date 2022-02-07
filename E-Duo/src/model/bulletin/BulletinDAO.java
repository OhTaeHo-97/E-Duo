package model.bulletin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.student.StudentVO;

public class BulletinDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ResultSet rs2;
	
	private String sql_insert = "INSERT INTO bulletin(bul_id, stu_id, category, title, content, image, regdate)"
			+ "VALUES"
			+ "(bulletin_seq.NEXTVAL,?,?,?,?,?,?)"; 
	private String sql_select = "SELECT * FROM member WHERE bul_id=?"; 
	private String sql_update = "UPDATE bulletin SET category=?, title=?, content=?, image=?, regdate=? WHERE bul_id=?";
	private String sql_delete = "DELETE FROM bulletin WHERE bul_id=?";
	private String sql_selectAll = "SELECT * FROM bulletin";
	private String sql_selectAllReply = "select * from Reply where bul_id = ? order by regDate desc";
	private String sql_selectMyBulletin = "SELECT * FROM bulletin WHERE stu_id = ?";
	
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
			pstmt.setString(6, vo.getRegDate());

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
				bdata.setRegDate(rs.getString("regDate"));
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
	
	public BulletinSet selectOne(BulletinVO vo) {	// 수정 필요, 한 개의 게시물을 눌렀을 경우 reply들이 보이도록 해야 함 reply와 연동 후 수정
		
		BulletinSet data = null;
		
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, vo.getBul_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BulletinSet();
				BulletinVO bul_data = new BulletinVO();
				ArrayList<ReplyVO> rep_datas = new ArrayList<ReplyVO>();
				
				bul_data.setBul_id(rs.getInt("bul_id"));
				bul_data.setCategory(rs.getString("category"));
				bul_data.setContent(rs.getString("content"));
				bul_data.setImage(rs.getString("image"));
				bul_data.setRegDate(rs.getString("regDate"));
				bul_data.setStu_id(rs.getString("stu_id"));
				bul_data.setTitle(rs.getString("title"));
				
				pstmt = conn.prepareStatement(sql_selectAllReply);
				pstmt.setInt(1, rs.getInt("bul_id"));
				rs2 = pstmt.executeQuery();
				while (rs2.next()) {
					ReplyVO rep_data = new ReplyVO();
					rep_data.setBul_id(rs2.getInt("bul_id"));
					rep_data.setContent(rs.getString("content"));
					rep_data.setRegDate(rs.getString("regDate"));
					rep_data.setRep_id(rs.getInt("rep_id"));
					rep_data.setStu_id(rs.getString("stu_id"));
					rep_datas.add(rep_data);
				}
				
				data.setBulletin(bul_data);
				data.setRdatas(rep_datas);
			}
		} catch (SQLException e) {
			System.out.println("Bulletin SelectOne문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return data;
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
	
	public ArrayList<BulletinVO> selectMyBulletin(BulletinVO vo) {
		conn = JDBCUtil.connect();
		ArrayList<BulletinVO> datas = new ArrayList<BulletinVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectMyBulletin);
			pstmt.setString(1, vo.getStu_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BulletinVO data = new BulletinVO();
				data.setBul_id(rs.getInt("bul_id"));
				data.setCategory(rs.getString("category"));
				data.setContent(rs.getString("content"));
				data.setImage(rs.getString("image"));
				data.setRegDate(rs.getString("regDate"));
				data.setTitle(rs.getString("title"));
				
				datas.add(data);
			}
		} catch (SQLException e) {
			System.out.println("BulletinDAO selectMyBulletin문 에러 : " + e);
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return datas;
	}
	
}
