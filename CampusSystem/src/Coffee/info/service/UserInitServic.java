package Coffee.info.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Coffee.info.dao.User;
import Coffee.info.dao.UserDAO;

import com.opensymphony.xwork2.ActionContext;

public class UserInitServic {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void getUserInit(){
		List users = userDAO.findAll();
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.put("users", users);
		
	}
	public void doDelete(String[] ids){
		String userIds = "";
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				userIds = userIds + ids[i];
				if (i < ids.length-1) {
					userIds = userIds + ",";
				}
			}
			userDAO.userDelete(userIds);
		}
		getUserInit();
	}
	public void doInsert(String username, String password, String role){
		User users = new User();
		users.setUsername(username);
		users.setPassword(password);
		users.setRole(role);
		List user = userDAO.findByUsername(username);
		if(user.size()>1){
			
		}else{
			userDAO.save(users);
		}
		getUserInit();
	}
	public void doLoad(String[] ids){
		if (ids != null && ids.length > 0) {
		 	String id = ids[0];
		 	User user = userDAO.findById(Integer.parseInt(id));
		 	ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			session.put("userload", user);
		}
	}
	public void doUpdate( String id, String username, String password, String role){
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		if(user == null){
			
		}else{
		userDAO.merge(user);
		}
		getUserInit();
	}
	public void doAjax(String username) throws IOException{
		List<User> list= userDAO.findByname(username);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (list != null && list.size()>0) {
			response.getWriter().print("<font color='red'>用户名已存在</font>");
		}else {
			response.getWriter().print("<font color='green'>用户名可使用</font>");
		}
		
	}
}
