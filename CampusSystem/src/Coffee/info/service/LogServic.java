package Coffee.info.service;

import java.util.List;
import java.util.Map;

import Coffee.info.dao.LogDAO;

import com.opensymphony.xwork2.ActionContext;

public class LogServic {
	public LogDAO getLogDao() {
		return logDao;
	}
	public void setLogDao(LogDAO logDao) {
		this.logDao = logDao;
	}
	private LogDAO logDao;
	
	public String Dolog() {
		List logList = logDao.findAll();
		Map session = ActionContext.getContext().getSession();
		session.put("logList", logList);
		return "log";
	}
}
