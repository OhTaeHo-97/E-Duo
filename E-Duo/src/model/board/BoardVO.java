package model.board;

public class BoardVO {
	private int index;
	private String stu_id;
	private String sort_title;
	private String title;
	private String content;
	private String image;
	
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getSort_title() {
		return sort_title;
	}
	public void setSort_title(String sort_title) {
		this.sort_title = sort_title;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
