package model.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getDummyData {
	public static void main(String[] args) {
		File dir = new File("C:/Users/Administrator/Desktop/eduo 자료/global");
		File[] files = dir.listFiles();
		for(int i = 0; i < files.length; i++) {
			try {
				FileInputStream file = new FileInputStream(files[i]);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				// 특정 이름의 시트 찾기 -> workbook.getSheet("찾는 시트의 이름")
				// 모든 시트를 순회하기
				// for(Integer sheetNum : workbook.getNumberOfSheets()) {
				// 		XSSFSheet sheet = workbook.getSheetAt(i);
				// }
				// 또는 Iterator<Sheet> s = workbook.iterator()를 사용해서 조회
				
				// 모든 행 조회
				Iterator<Row> rowIterator = sheet.iterator();
				while(rowIterator.hasNext()) {
					Row row = rowIterator.next();
					// 각각의 행에 존재하는 모든 열(cell) 순회
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// cell의 타입을 하고, 값을 가져온다
						switch(cell.getCellType()) {
							case NUMERIC:
								System.out.print("int: ");
								System.out.println((int)cell.getNumericCellValue() + "\t");
								// getNumericCellValue 메서드는 기본으로 double형 반환
								break;
							case STRING:
								System.out.print("string: ");
								System.out.println(cell.getStringCellValue() + "\t");
								break;
						}
					}
					System.out.println();
				}
				file.close();
				System.out.println(files[i]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			} catch(IOException e) {
				System.out.println("엑셀파일 workbook instance 생성 실패");
				e.printStackTrace();
			}
		}
	}
}
