package model.my_subject;

public class My_subjectVO {
	private int my_sub_id;
	private String academic_number;
	private String stu_id;
	private float credit;
	private int grade;
	private int semester;
	public int getMy_sub_id() {
		return my_sub_id;
	}
	public void setMy_sub_id(int my_sub_id) {
		this.my_sub_id = my_sub_id;
	}
	public String getAcademic_number() {
		return academic_number;
	}
	public void setAcademic_number(String academic_number) {
		this.academic_number = academic_number;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
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
