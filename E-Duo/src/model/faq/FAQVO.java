package model.faq;

public class FAQVO {
	private int fid;
	private String category;
	private String title;
	private String content;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
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
		return "FAQVO [fid=" + fid + ", category=" + category + ", title=" + title + ", content=" + content + "]";
	}
}
