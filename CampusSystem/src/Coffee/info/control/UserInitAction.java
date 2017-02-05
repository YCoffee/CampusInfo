package Coffee.info.control;

import java.io.IOException;
import java.net.URLDecoder;

import Coffee.info.dao.User;
import Coffee.info.service.UserInitServic;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserInitAction extends ActionSupport implements ModelDriven<User>{
	private UserInitServic userInitServic;
	private String username;
	private String password;
	private String type;
	private String[] user_key;
	private String id_key;
	private User user=new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	

	public String getId_key() {
		return id_key;
	}

	public void setId_key(String idKey) {
		id_key = idKey;
	}

	public String[] getUser_key() {
		return user_key;
	}

	public void setUser_key(String[] userKey) {
		user_key = userKey;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public UserInitServic getUserInitServic() {
		return userInitServic;
	}

	public void setUserInitServic(UserInitServic userInitServic) {
		this.userInitServic = userInitServic;
	}
/////////////////////////////////////////////////////////////////////////
	public String userInitAction() {
		userInitServic.getUserInit();
		return "success";
	}

	public String doDeleteAction() {
		userInitServic.doDelete(user_key);
		return "success";
	}

	public String doInsertAction() {
		userInitServic.doInsert(username, password, type);
		return "success";
	}
	public String AjaxAction() throws IOException{
		//½âÂë
		String getusername = URLDecoder.decode(user.getUsername(), "UTF-8");
		userInitServic.doAjax(getusername);
		return NONE;
	}
	public String doLoadAction(){
		if (user_key == null || user_key.length != 1) {
			return "falt";
		}else{
			userInitServic.doLoad(user_key);
			return "success";
		}
		
	}
	public String doUpdateAction(){
		userInitServic.doUpdate(id_key, username, password, type);
		return "success";
	}

}
