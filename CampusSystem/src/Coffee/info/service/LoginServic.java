package Coffee.info.service;

import java.util.List;
import java.util.Map;

import Coffee.info.dao.User;
import Coffee.info.dao.UserDAO;

import com.opensymphony.xwork2.ActionContext;

public class LoginServic {
	// ��hibernate�������ɵ�ע�������applicationContext����
	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public String DologinServic(String username, String password) {
		String result = "fault";
		List users = dao.findByUsername(username);
		User user = null;
		if (users != null && users.size() > 0) {
			user = (User) users.get(0);
			String dbpassword = user.getPassword();
			String dbrole = user.getRole();
			if (username != null && !username.equals("")) {
				if (password != null && !password.equals("")) {
					if (dbpassword.equals(password)) {
						Map session = ActionContext.getContext().getSession();
						session.put("user", user);
						if (dbrole.equals("admin")) {
							result = "admin";
						} else if (dbrole.equals("user")) {
							result = "user";
						}
					}
				}
			}
		}
		return result;
	}
}
