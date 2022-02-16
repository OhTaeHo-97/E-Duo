package model;

public class NoticeVO {
	private int nid;
	private String title;
	private String content;
	private String regDate;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	@Override
	public String toString() {
		return "NoticeVO [nid=" + nid + ", title=" + title + ", content=" + content + ", regDate=" + regDate + "]";
	}
}
