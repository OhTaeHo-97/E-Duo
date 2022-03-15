package model.faq;

public class FAQVO {
	private int faq_id;
	private String category;
	private String title;
	private String content;
	public int getFaq_id() {
		return faq_id;
	}
	public void setFaq_id(int faq_id) {
		this.faq_id = faq_id;
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
		return "FAQVO [fid=" + faq_id + ", category=" + category + ", title=" + title + ", content=" + content + "]";
	}
}
