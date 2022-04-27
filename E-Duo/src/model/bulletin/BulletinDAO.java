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
   ResultSet rs2;
   
   private String sql_insert = "INSERT INTO bulletin(bul_id, stu_id, nickname, category, title, content, image)"
         + "VALUES"
         + "((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,?,?,?,?)"; 
   private String sql_select = "SELECT * FROM bulletin WHERE bul_id=?"; 
   private String sql_update = "UPDATE bulletin SET category=?, title=?, content=?, image=?, regdate=? WHERE bul_id=?";
   private String sql_delete = "DELETE FROM bulletin WHERE bul_id=?";
   private String sql_selectAll = "SELECT * FROM bulletin order by bul_id desc";
   private String sql_selectAllReply = "select * from Reply where bul_id = ? order by regDate desc";
   private String sql_selectMyText = "SELECT * FROM bulletin WHERE stu_id = ? order by bul_id desc";
   private String sql_selectFilterAll = "SELECT * FROM bulletin where category = ? order by bul_id desc";
   private String sql_searchBulletinByTitle = "SELECT * FROM bulletin where category = ? and title LIKE '%'||?||'%' order by bul_id desc";
   private String sql_searchBulletinByContent = "SELECT * FROM bulletin where category = ? and content LIKE '%'||?||'%' order by bul_id desc";
   private String sql_searchBulletinByContent_Title = "SELECT * FROM bulletin where category = ? and (content LIKE '%'||?||'%' or title LIKE '%'||?||'%') order by bul_id desc";
   private String sql_selectMyBulletin = "SELECT * FROM bulletin WHERE stu_id = ? order by bul_id desc";
   private String sql_selectTop3 = "SELECT * FROM bulletin where category = ? and rownum < 5 order by bul_id desc";

   public ArrayList<BulletinVO> selectTop3(BulletinVO vo) {
      ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
      BulletinVO bul_data = null;
      
      conn = JDBCUtil.connect();
      
      try {
         pstmt = conn.prepareStatement(sql_selectTop3);
         pstmt.setString(1, vo.getCategory());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            bul_data = new BulletinVO();
            bul_data.setBul_id(rs.getInt("bul_id"));
            bul_data.setNickname(rs.getString("nickname"));
            bul_data.setCategory(rs.getString("category"));
            bul_data.setContent(rs.getString("content"));
            bul_data.setImage(rs.getString("image"));
            bul_data.setRegDate(rs.getString("regDate"));
            bul_data.setStu_id(rs.getString("stu_id"));
            bul_data.setTitle(rs.getString("title"));
            
            bul_datas.add(bul_data);
         }
      } catch (SQLException e) {
         System.out.println("Bulletin SelectTop3문 에러 : " + e);
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return bul_datas;
   }
   
   public boolean insert(BulletinVO vo) {
      int result = 0;
      
      conn = JDBCUtil.connect();
      try {
         pstmt = conn.prepareStatement(sql_insert);
         pstmt.setString(1, vo.getStu_id());
         pstmt.setString(2, vo.getNickname());
         pstmt.setString(3, vo.getCategory());
         pstmt.setString(4, vo.getTitle());
         pstmt.setString(5, vo.getContent());
         pstmt.setString(6, vo.getImage());
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
            bdata.setNickname(rs.getString("nickname"));
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
   
   public ArrayList<BulletinVO> selectCategoryFilterAll(BulletinVO vo) {
      ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
      BulletinVO bdata = null;
      
      conn = JDBCUtil.connect();
      try {
         pstmt = conn.prepareStatement(sql_selectFilterAll);
         pstmt.setString(1, vo.getCategory());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            bdata = new BulletinVO();
            bdata.setBul_id(rs.getInt("bul_id"));
            bdata.setNickname(rs.getString("nickname"));
            bdata.setCategory(rs.getString("category"));
            bdata.setContent(rs.getString("content"));
            bdata.setImage(rs.getString("image"));
            bdata.setRegDate(rs.getString("regDate"));
            bdata.setStu_id(rs.getString("stu_id"));
            bdata.setTitle(rs.getString("title"));
            
            bul_datas.add(bdata);
         }
      } catch (SQLException e) {
         System.out.println("Bulletin selectFilterAll문 에러 : " + e);
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return bul_datas;
   }
   
   public BulletinSet selectOne(BulletinVO vo) {
      
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
            bul_data.setNickname(rs.getString("nickname"));
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
               rep_data.setContent(rs2.getString("content"));
               rep_data.setRegDate(rs2.getString("regDate"));
               rep_data.setRep_id(rs2.getInt("rep_id"));
               rep_data.setStu_id(rs2.getString("stu_id"));
               rep_data.setNickname(rs2.getString("nickname"));
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
         pstmt.setString(1, vo.getCategory());
         pstmt.setString(2, vo.getTitle());
         pstmt.setString(3, vo.getContent());
         pstmt.setString(4, vo.getImage());
         pstmt.setString(5, vo.getRegDate());
         pstmt.setInt(6, vo.getBul_id());
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         System.out.println("Bulletin Update문 에러 : " + e);
         e.printStackTrace();
      } finally {
          JDBCUtil.disconnect(pstmt, conn);
      }
      
      return result == 1;
   }
   
   public ArrayList<BulletinVO> selectMyText(BulletinVO vo) {
      conn = JDBCUtil.connect();
      ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
      BulletinVO data = null;
      try {
         pstmt = conn.prepareStatement(sql_selectMyText);
         pstmt.setString(1, vo.getStu_id());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            data = new BulletinVO();
            data.setBul_id(rs.getInt("bul_id"));
            data.setNickname(rs.getString("nickname"));
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setImage(rs.getString("image"));
            data.setRegDate(rs.getString("regDate"));
            data.setStu_id(rs.getString("stu_id"));
            data.setTitle(rs.getString("title"));
            
            bul_datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("Student selectMyText문 에러 : " + e);
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      
      return bul_datas;
   }
   
   public ArrayList<BulletinVO> searchBulletinByTitle(BulletinVO vo) {
      // 제목 기반으로 게시판 검색(이때 게시판마다 검색이므로 category도 검색조건에 포함된다. 즉, 카테고리 + 제목 검색인 셈
      conn = JDBCUtil.connect();
      ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
      BulletinVO data = null;
      try {
         pstmt = conn.prepareStatement(sql_searchBulletinByTitle);
         pstmt.setString(1, vo.getCategory());
         pstmt.setString(2, vo.getTitle());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            data = new BulletinVO();
            data.setBul_id(rs.getInt("bul_id"));
            data.setNickname(rs.getString("nickname"));
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setImage(rs.getString("image"));
            data.setRegDate(rs.getString("regDate"));
            data.setStu_id(rs.getString("stu_id"));
            data.setTitle(rs.getString("title"));
            
            bul_datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("SearchBulletinByTitle문 에러 : " + e);
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return bul_datas;
      
   }
   
   public ArrayList<BulletinVO> searchBulletinByContent(BulletinVO vo) {
      // 내용 기반으로 게시판 검색(이때 게시판마다 검색이므로 category도 검색조건에 포함된다. 즉, 카테고리 + 내용 검색인 셈
      conn = JDBCUtil.connect();
      ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
      BulletinVO data = null;
      try {
         pstmt = conn.prepareStatement(sql_searchBulletinByContent);
         pstmt.setString(1, vo.getCategory());
         pstmt.setString(2, vo.getContent());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            data = new BulletinVO();
            data.setBul_id(rs.getInt("bul_id"));
            data.setNickname(rs.getString("nickname"));
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setImage(rs.getString("image"));
            data.setRegDate(rs.getString("regDate"));
            data.setStu_id(rs.getString("stu_id"));
            data.setTitle(rs.getString("title"));
            
            bul_datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("SearchContentByContent문 에러 : " + e);
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return bul_datas;
   }
   public ArrayList<BulletinVO> searchBulletinByContent_Title(BulletinVO vo) {
      // 내용, 제목 기반으로 게시판 검색(이때 게시판마다 검색이므로 category도 검색조건에 포함된다. 즉, 카테고리 + 제목 + 내용 검색인 셈
      //  "SELECT * FROM bulletin where category = ? and (content LIKE '%'||?||'%' or title LIKE '%'||?||'%'";
      conn = JDBCUtil.connect();
      ArrayList<BulletinVO> bul_datas = new ArrayList<BulletinVO>();
      BulletinVO data = null;
      try {
         pstmt = conn.prepareStatement(sql_searchBulletinByContent_Title);
         pstmt.setString(1, vo.getCategory());
         pstmt.setString(2, vo.getContent());
         pstmt.setString(3, vo.getTitle());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            data = new BulletinVO();
            data.setBul_id(rs.getInt("bul_id"));
            data.setNickname(rs.getString("nickname"));
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setImage(rs.getString("image"));
            data.setRegDate(rs.getString("regDate"));
            data.setStu_id(rs.getString("stu_id"));
            data.setTitle(rs.getString("title"));
            
            bul_datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("SearchContentByContent_Title문 에러 : " + e);
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return bul_datas;
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
            data.setNickname(rs.getString("nickname"));
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