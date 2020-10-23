package pojoclasses;

public class Feedback {
    
private int fid;	
private	String name;
private	String position;
private	String feedback;
private	String mail;
private	String mob;
	
	public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
