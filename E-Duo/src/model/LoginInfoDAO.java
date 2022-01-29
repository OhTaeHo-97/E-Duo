package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class LoginInfoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private String sql_selectAll = "select * from log_info";
	private String sql_loginUser = "select * from log_info where id = ? and password = ?";
	private String sql_loginAdmin = "select * from log_info where id = ? and password = ? and auth = 'Y'";
	private String sql_insert = "insert into log_info(id, password) values(?, ?)";
	private String sql_delete = "delete from login_info where id = ?";
	private String sql_update = "update login_info set password = ? where id = ?";
	
	public ArrayList<LoginInfoVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<LoginInfoVO> datas = new ArrayList<LoginInfoVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LoginInfoVO vo = new LoginInfoVO();
				vo.setAuth(rs.getString("auth"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("LoginInfoDAO selectAll() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public LoginInfoVO loginStudent(LoginInfoVO vo) {
		conn = JDBCUtil.connect();
		LoginInfoVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_loginUser);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new LoginInfoVO();
				data.setAuth(rs.getString("auth"));
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("LoginInfoDAO loginUser() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public LoginInfoVO loginAdmin(LoginInfoVO vo) {
		conn = JDBCUtil.connect();
		LoginInfoVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_loginAdmin);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new LoginInfoVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setAuth(rs.getString("auth"));
			}
		} catch (SQLException e) {
			System.out.println("LoginInfoVo loginAdmin() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(LoginInfoVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginInfoVo insert() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean delete(LoginInfoVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginInfoVo delete() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean update(LoginInfoVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginInfoVo update() ���� �� ���� �߻�");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
