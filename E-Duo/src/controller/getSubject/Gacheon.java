package controller.getSubject;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Gacheon {
	public static void main(String[] args) {
		String url = "https://info.gachon.ac.kr/ssu/showTimetable.do";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements ele = doc.select("div.cl-grid-centersplit > div.cl-grid-detail");
			System.out.println(ele);
			Iterator<Element> itr = ele.select("div.cl-grid-cell-inherit > div.cl-grid-row > div.cl-control > div.cl-text").iterator();
			while(itr.hasNext()) {
				String tlt = itr.next().text();
				System.out.println(tlt);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
