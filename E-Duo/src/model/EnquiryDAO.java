package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class EnquiryDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_selectAll = "select * from enquiry";
	private String sql_selectOne = "select * from enquiry where eid = ?";
	private String sql_insert = "insert into enquiry values((select nvl(max(eid), 0) + 1 from enquiry), ?, ?, ?)";
	private String sql_delete = "delete from enquiry where eid = ?";
	private String sql_update = "update enquiry set category = ?, title = ?, content = ? where eid = ?";
	
	public ArrayList<EnquiryVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<EnquiryVO> datas = new ArrayList<EnquiryVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EnquiryVO vo = new EnquiryVO();
				vo.setCategory(rs.getString("category"));
				vo.setContent(rs.getString("content"));
				vo.setEid(rs.getInt("eid"));
				vo.setTitle(rs.getString("title"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("EnquiryDAO selectAll() 실행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public EnquiryVO selectOne(EnquiryVO vo) {
		conn = JDBCUtil.connect();
		EnquiryVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getEid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new EnquiryVO();
				data.setCategory(rs.getString("category"));
				data.setContent(rs.getString("content"));
				data.setEid(rs.getInt("eid"));
				data.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("EnquiryDAO selectOne() 실행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(EnquiryVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("EnquiryDAO insert() 실행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean delete(EnquiryVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getEid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("EnquiryDAO delete() 실행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean update(EnquiryVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getEid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("EnquiryDAO delete() 실행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
