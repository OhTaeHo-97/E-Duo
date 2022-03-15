package model.notice;

public class NoticeVO {
	private int not_id;
	private String title;
	private String content;
	private String regDate;
	public int getNot_id() {
		return not_id;
	}
	public void setNot_id(int not_id) {
		this.not_id = not_id;
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
		return "NoticeVO [nid=" + not_id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + "]";
	}
}
