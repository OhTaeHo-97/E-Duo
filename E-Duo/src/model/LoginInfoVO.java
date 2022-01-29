package model;

public class LoginInfoVO {
	private String id;
	private String password;
	private String auth;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "LoginInfoVO [id=" + id + ", password=" + password + ", auth=" + auth + "]";
	}
}
