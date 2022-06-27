package model.subject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.common.JDBCUtil;

public class getGachonClass {
	public static void main(String[] args) {
		String sql = "INSERT INTO subject VALUES((SELECT NVL(MAX(sub_id), 0) + 1 from subject), ?, 8, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		File dir = new File("C:/Users/Administrator/Desktop/eduo 자료/global");
		File[] files = dir.listFiles();
		for(File f : files) {
			System.out.println(f.getName());
			if(f.getName().equals(".DS_Store")) {
				continue;
			}
			try {
				FileInputStream file = new FileInputStream(f);
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				int rowindex = 0;
				XSSFSheet sheet = workbook.getSheetAt(0);
				int rows = sheet.getPhysicalNumberOfRows();
				System.out.println(rows);
				String[] aca_num = new String[rows - 1];
				String[] subject_name = new String[rows - 1];
				String[] professor = new String[rows - 1];
				int[] credit_num = new int[rows - 1];
				String[] classroom = new String[rows - 1];
				String[] sub_sort = new String[rows - 1];
				String[] major = new String[rows - 1];
				String[][] lec_time = new String[rows - 1][9];
				for(rowindex = 1; rowindex < rows; rowindex++) {
					XSSFRow row = sheet.getRow(rowindex);
					String academic_num = "";
					if(row != null) {
						// 1 -> 학수번호, 2 -> 교과목명, 5 -> 이수, 6 -> 학점, 8 -> 담당교수, 9 -> 강의시간 10 -> 강의실
						
						// 학수번호
						XSSFCell cell = row.getCell(1);
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								academic_num = cell.getCellFormula();
								break;
							case NUMERIC:
								academic_num = cell.getNumericCellValue() + "";
								break;
							case STRING:
								academic_num = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	academic_num = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	academic_num = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						aca_num[rowindex - 1] = academic_num;
						
						// 교과목명
						cell = row.getCell(2);
						String sub_name = "";
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								sub_name = cell.getCellFormula();
								break;
							case NUMERIC:
								sub_name = cell.getNumericCellValue() + "";
								break;
							case STRING:
								sub_name = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	sub_name = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	sub_name = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						subject_name[rowindex - 1] = sub_name;
						
						// 이수
						cell = row.getCell(5);
						String sub = "";
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								sub = cell.getCellFormula();
								break;
							case NUMERIC:
								sub = cell.getNumericCellValue() + "";
								break;
							case STRING:
								sub = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	sub = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	sub = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						if(sub.contains("전")) {
							major[rowindex - 1] = "Y";
						} else {
							major[rowindex - 1] = "N";
						}
						sub_sort[rowindex - 1] = sub;
						
						// 학점
						cell = row.getCell(6);
						String credit = "";
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								credit = cell.getCellFormula();
								break;
							case NUMERIC:
								credit = cell.getNumericCellValue() + "";
								break;
							case STRING:
								credit = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	credit = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	credit = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						if(credit.equals("false")) {
							credit_num[rowindex - 1] = 0;
						} else {
							credit = credit.substring(0, 1);
							credit_num[rowindex - 1] = Integer.parseInt(credit);
						}
						
						// 담당교수
						cell = row.getCell(8);
						String prof = "";
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								prof = cell.getCellFormula();
								break;
							case NUMERIC:
								prof = cell.getNumericCellValue() + "";
								break;
							case STRING:
								prof = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	prof = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	prof = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						if(prof.equals("false")) {
							professor[rowindex - 1] = "NULL";
						} else {
							professor[rowindex - 1] = prof;
						}
						
						// 강의실
						cell = row.getCell(10);
						String room = "";
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								room = cell.getCellFormula();
								break;
							case NUMERIC:
								room = cell.getNumericCellValue() + "";
								break;
							case STRING:
								room = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	room = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	room = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						if(room.equals("false")) {
							classroom[rowindex - 1] = "NULL";
						} else {							
							classroom[rowindex - 1] = room;
						}
						
						// 강의시간
						cell = row.getCell(9);
						String time = "";
						if(cell != null) {
							switch(cell.getCellType()) {
							case FORMULA:
								time = cell.getCellFormula();
								break;
							case NUMERIC:
								time = cell.getNumericCellValue() + "";
								break;
							case STRING:
								time = cell.getStringCellValue()+ "";
	                        	break;
	                        case BLANK:
	                        	time = cell.getBooleanCellValue() + "";
	                        	break;
	                        case ERROR:
	                        	time = cell.getErrorCellValue() + "";
	                        	break;
							}
						}
						if(time.equals("false")) {
							Arrays.fill(lec_time[rowindex - 1], "NULL");
						} else {
							String[] first_time = {"NULL", "NULL", "NULL"};
							String[] second_time = {"NULL", "NULL", "NULL"};
							String[] third_time = {"NULL", "NULL", "NULL"};
							String[] time_inf = time.split(" ,");
							for(int i = 0; i < time_inf.length; i++) {
								String time_sort = time_inf[i].substring(1);
								String start = "";
								String end = "";
								switch(time_sort) {
								case "1":
									start = "09:00";
									end = "09:50";
									break;
								case "A":
									start = "09:30";
									end = "10:45";
									break;
								case "2":
									start = "10:00";
									end = "10:50";
									break;
								case "3":
									start = "11:00";
									end = "11:50";
									break;
								case "B":
									start = "11:00";
									end = "12:15";
									break;
								case "4":
									start = "12:00";
									end = "12:50";
									break;
								case "5":
									start = "13:00";
									end = "13:50";
									break;
								case "C":
									start = "13:00";
									end = "14:15";
									break;
								case "6":
									start = "14:00";
									end = "14:50";
									break;
								case "D":
									start = "14:30";
									end = "15:45";
									break;
								case "7":
									start = "15:00";
									end = "15:50";
									break;
								case "8":
									start = "16:00";
									end = "16:50";
									break;
								case "E":
									start = "16:00";
									end = "17:15";
									break;
								case "9":
									start = "17:00";
									end = "17:50";
									break;
								case "10":
									start = "18:00";
									end = "18:50";
									break;
								case "11":
									start = "19:00";
									end = "19:50";
									break;
								case "12":
									start = "20:00";
									end = "20:50";
									break;
								case "13":
									start = "21:00";
									end = "21:50";
									break;
								case "14":
									start = "22:00";
									end = "22:50";
									break;
								}
								if(time_inf[i].contains("월")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "MON";
										first_time[1] = start;
										first_time[2] = end;
									} else if(first_time[0].equals("월")) {
										first_time[2] = end;
									}
								} else if(time_inf[i].contains("화")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "TUE";
										first_time[1] = start;
										first_time[2] = end;
									} else if(first_time[0].equals("월")) {
										second_time[0] = "TUE";
										second_time[1] = start;
										second_time[2] = end;
									} else if(first_time[0].equals("화")) {
										first_time[2] = end;
									}
								} else if(time_inf[i].contains("수")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "WED";
										first_time[1] = start;
										first_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화")) && second_time[0].equals("NULL")) {
										second_time[0] = "WED";
										second_time[1] = start;
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화")) && second_time[0].equals("수")) {
										second_time[2] = end;
									} else if(first_time[0].equals("월") && second_time[0].equals("화")) {
										third_time[0] = "WED";
										third_time[1] = start;
										third_time[2] = end;
									} else if(first_time[0].equals("수")) {
										first_time[2] = end;
									}
								} else if(time_inf[i].contains("목")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "THU";
										first_time[1] = start;
										first_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수")) && second_time[0].equals("NULL")) {
										second_time[0] = "THU";
										second_time[1] = start;
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수")) && second_time[0].equals("목")) {
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화")) && (second_time[0].equals("화") || second_time[0].equals("수")) && third_time[0].equals("NULL")) {
										third_time[0] = "THU";
										third_time[1] = start;
										third_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화")) && (second_time[0].equals("화") || second_time[0].equals("수")) && third_time[0].equals("목")) {
										third_time[2] = end;
									} else if(first_time[0].equals("목")) {
										first_time[2] = end;
									}
								} else if(time_inf[i].contains("금")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "FRI";
										first_time[1] = start;
										first_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목")) && second_time[0].equals("NULL")) {
										second_time[0] = "FRI";
										second_time[1] = start;
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목")) && second_time[0].equals("금")) {
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수")) && (second_time[0].equals("화") || second_time[0].equals("수") || second_time[0].equals("목")) && third_time[0].equals("NULL")) {
										third_time[0] = "FRI";
										third_time[1] = start;
										third_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수")) && (second_time[0].equals("화") || second_time[0].equals("수") || second_time[0].equals("목")) && third_time[0].equals("금")) {
										third_time[2] = end;
									} else if(first_time[0].equals("금")) {
										first_time[2] = end;
									}
								} else if(time_inf[i].contains("금")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "FRI";
										first_time[1] = start;
										first_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목")) && second_time[0].equals("NULL")) {
										second_time[0] = "FRI";
										second_time[1] = start;
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목")) && second_time[0].equals("금")) {
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수")) && (second_time[0].equals("화") || second_time[0].equals("수") || second_time[0].equals("목")) && third_time[0].equals("NULL")) {
										third_time[0] = "FRI";
										third_time[1] = start;
										third_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수")) && (second_time[0].equals("화") || second_time[0].equals("수") || second_time[0].equals("목")) && third_time[0].equals("금")) {
										third_time[2] = end;
									} else if(first_time[0].equals("금")) {
										first_time[2] = end;
									}
								} else if(time_inf[i].contains("토")) {
									if(first_time[0].equals("NULL")) {
										first_time[0] = "SAT";
										first_time[1] = start;
										first_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목") || first_time[0].equals("금")) && second_time[0].equals("NULL")) {
										second_time[0] = "SAT";
										second_time[1] = start;
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목") || first_time[0].equals("금")) && second_time[0].equals("토")) {
										second_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목")) && (second_time[0].equals("화") || second_time[0].equals("수") || second_time[0].equals("목") || second_time[0].equals("금")) && third_time[0].equals("NULL")) {
										third_time[0] = "SAT";
										third_time[1] = start;
										third_time[2] = end;
									} else if((first_time[0].equals("월") || first_time[0].equals("화") || first_time[0].equals("수") || first_time[0].equals("목")) && (second_time[0].equals("화") || second_time[0].equals("수") || second_time[0].equals("목") || second_time[0].equals("금")) && third_time[0].equals("토")) {
										third_time[2] = end;
									} else if(first_time[0].equals("토")) {
										first_time[2] = end;
									}
								}
							}
							lec_time[rowindex - 1][0] = first_time[0];
							lec_time[rowindex - 1][1] = first_time[1];
							lec_time[rowindex - 1][2] = first_time[2];
							lec_time[rowindex - 1][3] = second_time[0];
							lec_time[rowindex - 1][4] = second_time[1];
							lec_time[rowindex - 1][5] = second_time[2];
							lec_time[rowindex - 1][6] = third_time[0];
							lec_time[rowindex - 1][7] = third_time[1];
							lec_time[rowindex - 1][8] = third_time[2];
						}
					}
				}
				conn = JDBCUtil.connect();
				for(int i = 0; i < aca_num.length; i++) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, aca_num[i]);
					pstmt.setString(2, subject_name[i]);
					pstmt.setString(3, professor[i]);
					pstmt.setInt(4, credit_num[i]);
					pstmt.setString(5, classroom[i]);
					pstmt.setString(6, sub_sort[i]);
					pstmt.setString(7, major[i]);
					for(int j = 0; j < 9; j++) {
						pstmt.setString(8 + j, lec_time[i][j]);
					}
					pstmt.executeUpdate();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("엑셀파일 workbook instance 생성 실패");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("PreparedStatement 생성 실패");
				e.printStackTrace();
			}
		}
	}
}
