package Coffee.info.control;

import org.apache.log4j.Logger;

import Coffee.info.service.LoginServic;

public class LoginAction {
	private LoginServic loginServic;
	private String username;
	private String password;
	private static final Logger log = Logger.getLogger(LoginAction.class);

	public LoginServic getLoginServic() {
		return loginServic;
	}
	public void setLoginServic(LoginServic loginServic) {
		this.loginServic = loginServic;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String dologinAction() {
		//System.out.println(username+"------"+password);
        String result = loginServic.DologinServic(username, password);
		String logInfo;
        if (result.equals("fault")) {
        	logInfo = "用户："+ username +"试图登陆系统失败！登陆密码为："+password+"";
		}else{
			logInfo = "用户："+ username +"登陆系统成功！";
		}
        log.info(logInfo);
        username = null;
        password = null;
        return result;
	}
}
