package web2tutorial.spring.springweb.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	private static final long serialVersionUID = -202399887309221180L;

	private String userName;
	private String password;
	private String message;
	
	public String execute() {
		setMessage("Hello " + userName);
		return "SUCCESS";
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
