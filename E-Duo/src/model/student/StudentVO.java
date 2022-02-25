package model.student;

import java.sql.Date;

public class StudentVO {
	private String name;
	private String stu_id;
	private String cellphone;
	private int postcode;
	private String address;
	private String detail_address;
	private String refernece;
	private int uni_id;
	private String email;
	private String gender;
	private String birth;
	private int grade;
	private int semester;
	private float obj_credit;
	private int graduate_credit;
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public String getRefernece() {
		return refernece;
	}
	public void setRefernece(String refernece) {
		this.refernece = refernece;
	}
	public int getUni_id() {
		return uni_id;
	}
	public void setUni_id(int uni_id) {
		this.uni_id = uni_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getObj_credit() {
		return obj_credit;
	}
	public void setObj_credit(float obj_credit) {
		this.obj_credit = obj_credit;
	}
	public int getGraduate_credit() {
		return graduate_credit;
	}
	public void setGraduate_credit(int graduate_credit) {
		this.graduate_credit = graduate_credit;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

	
}
