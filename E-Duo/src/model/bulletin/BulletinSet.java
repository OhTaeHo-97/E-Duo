package model.bulletin;

import java.util.ArrayList;

public class BulletinSet { 
	private BulletinVO bulletin;
	private ArrayList<ReplyVO> rdatas = new ArrayList<ReplyVO>();
	
	public BulletinVO getBulletin() {
		return bulletin;
	}
	public void setBulletin(BulletinVO bulletin) {
		this.bulletin = bulletin;
	}
	public ArrayList<ReplyVO> getRdatas() {
		return rdatas;
	}
	public void setRdatas(ArrayList<ReplyVO> rdatas) {
		this.rdatas = rdatas;
	}

}
