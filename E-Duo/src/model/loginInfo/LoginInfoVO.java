package model.loginInfo;

public class LoginInfoVO {
	private String stu_id;
	private String password;
	private String auth;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "LoginInfoVO [id=" + stu_id + ", password=" + password + ", auth=" + auth + "]";
	}
}