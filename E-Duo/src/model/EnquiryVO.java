package model;

public class EnquiryVO {
	private int eid;
	private String category;
	private String title;
	private String content;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	@Override
	public String toString() {
		return "EnquiryVO [eid=" + eid + ", category=" + category + ", title=" + title + ", content=" + content + "]";
	}
}
