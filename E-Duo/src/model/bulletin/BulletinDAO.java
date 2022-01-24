package model.bulletin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public boolean insertBulletin(BulletinVO vo) {
		return true;
	}
}
