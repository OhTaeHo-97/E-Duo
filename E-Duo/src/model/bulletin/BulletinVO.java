package model.bulletin;

public class BulletinVO {
	private int bul_id;
	private String stu_id;
	private String category;
	private String title;
	private String content;
	private String image;
	private String regdate;
	
	
	
	public int getBul_id() {
		return bul_id;
	}
	public void setBul_id(int bul_id) {
		this.bul_id = bul_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
