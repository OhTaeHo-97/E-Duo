package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
   public static Connection connect() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "my_project";
      String password = "1234";
      
      Connection conn = null;
      
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         System.out.println("DB 연결 중 문제 발생");
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
      return conn;
   }
   
   public static void disconnect(PreparedStatement pstmt, Connection conn) {
      try {
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 해제 중 문제 발생");
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
   }
}