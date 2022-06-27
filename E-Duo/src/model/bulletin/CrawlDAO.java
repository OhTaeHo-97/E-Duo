package model.bulletin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.common.JDBCUtil;

public class CrawlDAO {
   public static void insertCrawlDB() {
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql_InsertFree = "Insert Into Bulletin(bul_id, stu_id, nickname, category, title, content, image, regDate) "
            + "values((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,'free',?,?,?,?)";
      
      String sql_InsertInfo = "Insert Into Bulletin(bul_id, stu_id, nickname, category, title, content, image, regDate) "
            + "values((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,'info',?,?,?,?)";
      
      String sql_InsertFresh = "Insert Into Bulletin(bul_id, stu_id, nickname, category, title, content, image, regDate) "
            + "values((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,'fresh',?,?,?,?)";
      
      String sql_InsertAd = "Insert Into Bulletin(bul_id, stu_id, nickname, category, title, content, image, regDate) "
            + "values((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,'ad',?,?,?,?)";
      
      String sql_InsertJob = "Insert Into Bulletin(bul_id, stu_id, nickname, category, title, content, image, regDate) "
            + "values((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,'job',?,?,?,?)";
      
      String sql_InsertMarket = "Insert Into Bulletin(bul_id, stu_id, nickname, category, title, content, image, regDate) "
            + "values((select nvl(max(bul_id), 0) + 1 from Bulletin),?,?,'market',?,?,?,?)";
      
      String url_free = "https://everytime.kr/370442";
      String url_info = "https://everytime.kr/375125";
      String url_fresh = "https://everytime.kr/375127";
      String url_ad = "https://everytime.kr/375124";
      String url_job = "https://everytime.kr/375126";
      String url_market = "https://everytime.kr/420102";
      String sql_insert[] = {sql_InsertFree, sql_InsertInfo, sql_InsertFresh, sql_InsertAd, sql_InsertJob, sql_InsertMarket};
      String url[] = {url_free, url_info, url_fresh, url_ad, url_job, url_market};
      // int bul_id    String stu_id    String nickname      String category      String title   String content      String image   String regDate
      int result = 0;
      conn = JDBCUtil.connect();
      System.out.println(conn);
      for (int i = 0 ; i < 6 ; i++) {
         try {
            Document doc = Jsoup.connect(url[i]).get();
            Elements ele = doc.select("div.wrap articles");
            Iterator<Element> itr_nickname = ele.select("h3.small").iterator();
            Iterator<Element> itr_title = ele.select("h2.medium").iterator();
            Iterator<Element> itr_content = ele.select("p.small").iterator();
            Iterator<Element> itr_regDate = ele.select("time.small").iterator();
            // 이미지, 아이디 고민
            // Iterator<Element> itr_image = ele.select("div.attachthumbnail > ").iterator();
            while(itr_title.hasNext()) {
            	System.out.println(itr_title.next());
             }
//            while(itr_title.hasNext()) {
//               pstmt = conn.prepareStatement(sql_insert[i]);
//               pstmt.setString(2, itr_nickname.next().text());
//               pstmt.setString(3, itr_title.next().text());
//               pstmt.setString(4, itr_content.next().text());
//               pstmt.setString(6, itr_regDate.next().text());
//            }
//            result = pstmt.executeUpdate(sql_insert[i]);
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            System.out.println("크롤링 데이터 수 : " + result);
            JDBCUtil.disconnect(pstmt, conn);
         }
      }
   }
}