package model.my_subject;

import model.subject.SubjectVO;

public class My_subjectSet {
	private My_subjectVO mvo;
	private SubjectVO svo;
	
	public void setMy_subjectVO(My_subjectVO mvo) {
		this.mvo = mvo;
	}
	public My_subjectVO getMy_subjectVO() {
		return mvo;
	}
	public void setSubjectVO(SubjectVO svo) {
		this.svo = svo;
	}
	public SubjectVO getSubjectVO() {
		return svo;
	}
}
