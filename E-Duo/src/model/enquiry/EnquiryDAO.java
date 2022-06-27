package model.enquiry;

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
	private String sql_selectOne = "select * from enquiry where enq_id = ?";
	private String sql_insert = "insert into enquiry values((select nvl(max(enq_id), 0) + 1 from enquiry), ?, ?, ?)";
	private String sql_delete = "delete from enquiry where enq_id = ?";
	private String sql_update = "update enquiry set category = ?, title = ?, content = ? where enq_id = ?";
	
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
				vo.setEnq_id(rs.getInt("enq_id"));
				vo.setTitle(rs.getString("title"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("EnquiryDAO selectAll() 수행 중 문제 발생");
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
			pstmt.setInt(1, vo.getEnq_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new EnquiryVO();
				data.setCategory(rs.getString("category"));
				data.setContent(rs.getString("content"));
				data.setEnq_id(rs.getInt("enq_id"));
				data.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("EnquiryDAO selectOne() 수행 중 문제 발생");
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
			System.out.println("EnquiryDAO insert() 수행 중 문제 발생");
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
			pstmt.setInt(1, vo.getEnq_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("EnquiryDAO delete() 수행 중 문제 발생");
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
			pstmt.setInt(4, vo.getEnq_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("EnquiryDAO delete() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
