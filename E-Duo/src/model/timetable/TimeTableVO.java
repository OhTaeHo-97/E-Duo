package model.timetable;

import model.subject.SubjectVO;

public class TimeTableVO {
	private int my_sub_id;
	private SubjectVO subjectVO;
	private double first_start;
	private double first_height;
	private double second_start;
	private double second_height;
	private double third_start;
	private double third_height;
	public int getMy_sub_id() {
		return my_sub_id;
	}
	public void setMy_sub_id(int my_sub_id) {
		this.my_sub_id = my_sub_id;
	}
	public SubjectVO getSubjectVO() {
		return subjectVO;
	}
	public void setSubjectVO(SubjectVO subjectVO) {
		this.subjectVO = subjectVO;
	}
	public double getFirst_start() {
		return first_start;
	}
	public void setFirst_start(double first_start) {
		this.first_start = first_start;
	}
	public double getFirst_height() {
		return first_height;
	}
	public void setFirst_height(double first_height) {
		this.first_height = first_height;
	}
	public double getSecond_start() {
		return second_start;
	}
	public void setSecond_start(double second_start) {
		this.second_start = second_start;
	}
	public double getSecond_height() {
		return second_height;
	}
	public void setSecond_height(double second_height) {
		this.second_height = second_height;
	}
	public double getThird_start() {
		return third_start;
	}
	public void setThird_start(double third_start) {
		this.third_start = third_start;
	}
	public double getThird_height() {
		return third_height;
	}
	public void setThird_height(double third_height) {
		this.third_height = third_height;
	}
}
