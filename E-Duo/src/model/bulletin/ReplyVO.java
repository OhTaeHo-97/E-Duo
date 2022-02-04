package model.bulletin;

import java.sql.Date;

public class ReplyVO {
	private int rep_id;
	private String stu_id;
	private int bul_id;
	private String content;
	private String regDate;
	private String anonymity;
	public String getAnonymity() {
		return anonymity;
	}
	public void setAnonymity(String anonymity) {
		this.anonymity = anonymity;
	}
	public int getRep_id() {
		return rep_id;
	}
	public void setRep_id(int rep_id) {
		this.rep_id = rep_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public int getBul_id() {
		return bul_id;
	}
	public void setBul_id(int bul_id) {
		this.bul_id = bul_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}