package Coffee.info.control;

import Coffee.info.service.OrderService;

public class OrderAction {
	private OrderService orderService;
	private String[] business_key;
	public String[] getBusiness_key() {
		return business_key;
	}
	public void setBusiness_key(String[] businessKey) {
		business_key = businessKey;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	public String doInitOrderAction(){
		orderService.doInitOrderService();
		return "success";
	}
	public String doChooseOrderAction(){
		orderService.doChooseOrderService(business_key);
		//清空数组，防止未选择依旧成功提交
		business_key = null;
		return "success";
	}
	public String doUnsubscribeAction(){
		orderService.doUnsubscribeService(business_key);
		//清空数组，防止未选择依旧成功提交
		business_key = null;
		return "success";
	}

}
