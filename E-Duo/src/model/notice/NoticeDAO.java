package model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class NoticeDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_selectAll = "select * from notice";
	private String sql_selectOne = "select * from notice where nid = ?";
	private String sql_insert = "insert into notice(nid, title, content) values((select nvl(max(nid), 0) + 1 from notice), ?, ?)";
	private String sql_delete = "delete from notice where nid = ?";
	private String sql_update = "update notice set title = ?, content = ?, regDate = sysdate where nid = ?";
	
	public ArrayList<NoticeVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<NoticeVO> datas = new ArrayList<NoticeVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setContent(rs.getString("content"));
				vo.setNid(rs.getInt("nid"));
				vo.setRegDate(rs.getString("regDate"));
				vo.setTitle(rs.getString("title"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("NoticeDAO selectAll() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public NoticeVO selectOne(NoticeVO vo) {
		conn = JDBCUtil.connect();
		NoticeVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getNid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new NoticeVO();
				data.setContent(rs.getString("content"));
				data.setNid(rs.getInt("nid"));
				data.setRegDate(rs.getString("regDate"));
				data.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("NoticeDAO selectOne() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(NoticeVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NoticeDAO insert() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean delete(NoticeVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getNid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NoticeDAO delete() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean update(NoticeVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NoticeDAO update() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}