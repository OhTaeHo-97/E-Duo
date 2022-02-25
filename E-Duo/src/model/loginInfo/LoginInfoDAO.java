package model.loginInfo;

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
	
	private String sql_selectAll = "select * from login_info";
	private String sql_checkId = "select * from login_info where stu_id = ?";
	private String sql_loginUser = "select * from login_info where stu_id = ? and password = ?";
	private String sql_loginAdmin = "select * from login_info where stu_id = ? and password = ? and auth = 'a'";
	private String sql_insert = "insert into login_info(stu_id, password) values(?, ?)";
	private String sql_delete = "delete from login_info where stu_id = ?";
	private String sql_update = "update login_info set password = ? where stu_id = ?";
	
	public ArrayList<LoginInfoVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<LoginInfoVO> datas = new ArrayList<LoginInfoVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LoginInfoVO vo = new LoginInfoVO();
				vo.setAuth(rs.getString("auth"));
				vo.setStu_id(rs.getString("stu_id"));
				vo.setPassword(rs.getString("password"));
				datas.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("LoginInfoDAO selectAll() 수행 중 문제 발생");
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
			pstmt.setString(1, vo.getStu_id());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new LoginInfoVO();
				data.setAuth(rs.getString("auth"));
				data.setStu_id(rs.getString("stu_id"));
				data.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("LoginInfoDAO loginUser() 수행 중 문제 발생");
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
			pstmt.setString(1, vo.getStu_id());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new LoginInfoVO();
				data.setStu_id(rs.getString("stu_id"));
				data.setPassword(rs.getString("password"));
				data.setAuth(rs.getString("auth"));
			}
		} catch (SQLException e) {
			System.out.println("LoginInfoVo loginAdmin() 수행 중 문제 발생");
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
			pstmt.setString(1, vo.getStu_id());
			pstmt.setString(2, vo.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginInfoVo insert() 수행 중 문제 발생");
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
			pstmt.setString(1, vo.getStu_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginInfoVo delete() 수행 중 문제 발생");
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
			pstmt.setString(2, vo.getStu_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginInfoVo update() 수행 중 문제 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public int checkId(LoginInfoVO vo) { // ID 중복검사 : 버튼클릭해서 중복여부 확인
		int usable = 0;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_checkId);
			//select * from member where member_id = ?
			pstmt.setString(1, vo.getStu_id());
			rs = pstmt.executeQuery();
			if(rs.next()) { // 존재한다면?? false값 반환
				usable = 0;
			}
			else {			// 존재안한다면?? true값 반환
				usable = 1;
			}
			
		} catch (SQLException e) {
			System.out.println("LoginInfoDAO checkId진행 중 오류");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return usable;
	}
}