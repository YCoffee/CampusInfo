package Coffee.info.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import Coffee.info.dao.User;
import Coffee.info.dao.UserOrder;
import Coffee.info.dao.UserOrderDAO;

import com.opensymphony.xwork2.ActionContext;

public class OrderService {
	private UserOrderDAO uod;

	public UserOrderDAO getUod() {
		return uod;
	}

	public void setUod(UserOrderDAO uod) {
		this.uod = uod;
	}
	

	public void doInitOrderService() {
		ActionContext Context = ActionContext.getContext();
		Map session = Context.getSession();
		User user = (User)session.get("user");
		int userid = user.getId();
		List orderlist = uod.findByUserid(userid);
		session.put("orderlist", orderlist);
	}

	public void doChooseOrderService(String[] business_key) {
		ActionContext Context = ActionContext.getContext();
		Map session = Context.getSession();
		User user = (User)session.get("user");
		int userid = user.getId();
		UserOrder userOrder = new UserOrder();
		if (business_key == null) {
			//留空
			System.out.println("请选择业务！");
		}else{
		for (int i = 0; i < business_key.length; i++) {
			//获取Timestamp类型的当前系统时间
			Timestamp time = new Timestamp(System.currentTimeMillis());
			Short type = 1;
			userOrder.setUserid(userid);
			userOrder.setOrderBusiness(business_key[i]);
			userOrder.setOrderTime(time);
			userOrder.setOrderState(type);
			if (uod.getUserorder(userid, business_key[i])) {
				System.out.println("业务已订阅，请勿重复订阅！");
			}else{
				uod.save(userOrder);
			}
		}
		doInitOrderService();
		}
	}
	
	public void doUnsubscribeService(String[] business_key) {
		ActionContext Context = ActionContext.getContext();
		Map session = Context.getSession();
		User user = (User)session.get("user");
		int userid = user.getId();
		String business="";
		if (business_key == null) {
			//留空
			System.out.println("请选择业务！");
		}else{
		for (int i = 0; i < business_key.length; i++) {
			business = business+business_key[i];
			if (i<business_key.length-1) {
				business = business+",";
			}
		}
		System.out.println(business);
		//'订阅状态：0-退订、1-生效'
		uod.doUpdateState(userid, business, 0);
		doInitOrderService();
		}
	}
}
