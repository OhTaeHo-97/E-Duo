package model.subject;

import java.sql.Date;

public class SubjectVO {
	private int sub_id;
	private int academic_number;
	private int uni_id;
	private String subject_name;
	private String professor;
	private int credit_num;
	private String classroom;
	private String start_time;
	private String end_time;
	private String subject_date;


	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getAcademic_number() {
		return academic_number;
	}
	public void setAcademic_number(int academic_number) {
		this.academic_number = academic_number;
	}
	public int getUni_id() {
		return uni_id;
	}
	public void setUni_id(int uni_id) {
		this.uni_id = uni_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getCredit_num() {
		return credit_num;
	}
	public void setCredit_num(int credit_num) {
		this.credit_num = credit_num;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getSubject_date() {
		return subject_date;
	}
	public void setSubject_date(String subject_date) {
		this.subject_date = subject_date;
	}
	
}
