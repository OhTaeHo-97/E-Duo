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
   private String sql_searchFAQByTitle = "select * from FAQ where title LIKE '%'||?||'%'";
   private String sql_searchFAQByContent = "select * from FAQ where content LIKE '%'||?||'%'";
   private String sql_searchFAQByContent_Title = "select * from FAQ where content LIKE '%'||?||'%' or title LIKE '%'||?||'%'";
   
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
         System.out.println("FAQDAO selectAll() 수행 중 문제 발생");
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
         System.out.println("FAQDAO selectAll() 수행 중 문제 발생");
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
         System.out.println("FAQDAO insert() 수행 중 문제 발생");
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
         System.out.println("FAQDAO delete() 수행 중 문제 발생");
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
         System.out.println("FAQDAO update() 수행 중 문제 발생");
         System.out.println(e.getMessage());
         e.printStackTrace();
         return false;
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return true;
   }
   
   // private String sql_searchFAQ = "select * from FAQ where title LIKE '%'||?||'%'";
   public ArrayList<FAQVO> searchFAQByTitle(FAQVO vo) {
      conn = JDBCUtil.connect();
      ArrayList<FAQVO> datas = new ArrayList<FAQVO>();
      try {
         pstmt = conn.prepareStatement(sql_searchFAQByTitle);
         pstmt.setString(1, vo.getTitle());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            FAQVO data = new FAQVO();
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setFid(rs.getInt("fid"));
            data.setTitle(rs.getString("title"));
            datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("FAQDAO searchFAQByTitle() 수행 중 문제 발생");
         System.out.println(e.getMessage());
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return datas;
   }
   
   public ArrayList<FAQVO> searchFAQByContent(FAQVO vo) {
      conn = JDBCUtil.connect();
      ArrayList<FAQVO> datas = new ArrayList<FAQVO>();
      try {
         pstmt = conn.prepareStatement(sql_searchFAQByContent);
         pstmt.setString(1, vo.getContent());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            FAQVO data = new FAQVO();
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setFid(rs.getInt("fid"));
            data.setTitle(rs.getString("title"));
            datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("FAQDAO searchFAQByContent() 수행 중 문제 발생");
         System.out.println(e.getMessage());
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return datas;
   }
   
   public ArrayList<FAQVO> searchFAQByContent_Title(FAQVO vo) {
      conn = JDBCUtil.connect();
      ArrayList<FAQVO> datas = new ArrayList<FAQVO>();
      try {
         pstmt = conn.prepareStatement(sql_searchFAQByContent_Title);
         pstmt.setString(1, vo.getContent());
         pstmt.setString(2, vo.getTitle());
         rs = pstmt.executeQuery();
         while(rs.next()) {
            FAQVO data = new FAQVO();
            data.setCategory(rs.getString("category"));
            data.setContent(rs.getString("content"));
            data.setFid(rs.getInt("fid"));
            data.setTitle(rs.getString("title"));
            datas.add(data);
         }
      } catch (SQLException e) {
         System.out.println("FAQDAO searchFAQByContent_Title() 수행 중 문제 발생");
         System.out.println(e.getMessage());
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return datas;
   }
}