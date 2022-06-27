package model.enquiry;

public class EnquiryVO {
	private int enq_id;
	private String category;
	private String title;
	private String content;
	public int getEnq_id() {
		return enq_id;
	}
	public void setEnq_id(int enq_id) {
		this.enq_id = enq_id;
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
		return "EnquiryVO [eid=" + enq_id + ", category=" + category + ", title=" + title + ", content=" + content + "]";
	}
}
