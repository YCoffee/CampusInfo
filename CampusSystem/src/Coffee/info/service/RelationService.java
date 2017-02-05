package Coffee.info.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Coffee.info.dao.User;
import Coffee.info.dao.UserDAO;
import Coffee.info.dao.UserRelation;
import Coffee.info.dao.UserRelationDAO;

import com.opensymphony.xwork2.ActionContext;
public class RelationService {
	private UserRelationDAO urd;
	private UserDAO ud;
	
	public UserRelationDAO getUrd() {
		return urd;
	}

	public void setUrd(UserRelationDAO urd) {
		this.urd = urd;
	}

	public UserDAO getUd() {
		return ud;
	}

	public void setUd(UserDAO ud) {
		this.ud = ud;
	}

	
	public boolean initRelation(){
		boolean  judgement = false;
		Map session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		List relationlist = urd.findRelationByMyId(user.getId());
		List newRelationList = new ArrayList();
		if (relationlist != null && relationlist.size() > 0) {
			UserRelation userRelation = null;
			for (int i = 0; i < relationlist.size(); i++) {
				Object[] obj = (Object[]) relationlist.get(i);
				Integer otherId = (Integer) obj[0];
				String relation = (String) obj[1];
				Short state = (Short) obj[2];
				String otherName = (String) obj[3];
				
				userRelation = new UserRelation();
				userRelation.setOtherId(otherId);
				userRelation.setOtherName(otherName);
				userRelation.setRelateion(relation);
				userRelation.setState(state);
				
				newRelationList.add(userRelation);
			}
		}
		session.put("relationlist", newRelationList);
		
		
		List userlist = ud.findRelationForMyID(user.getId());
		UserRelation userRelation = null;
		User us = null;
		List temp = new ArrayList();
		for (int i = 0; i < newRelationList.size(); i++) {
			userRelation = (UserRelation) newRelationList.get(i);
			Integer otherId = userRelation.getOtherId();
			
			for (int j = 0; j < userlist.size(); j++) {
				us = (User) userlist.get(j);
				Integer id = us.getId();
				
				if (id.intValue() == otherId.intValue()) {
					temp.add(us);
				}
			}
		}
		userlist.removeAll(temp);
		session.put("userlist", userlist);
		
		return judgement = true;
	}
	
	public boolean createRelation(String[] otherids,String relation){
		boolean  judgement = false;
		if (otherids != null && otherids.length > 0) {
			Map session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			for (int i = 0; i < otherids.length; i++) {
				UserRelation ur = new UserRelation();
				ur.setMyId(user.getId());
				ur.setOtherId(Integer.valueOf(otherids[i]));
				ur.setRelateion(relation);
				ur.setState((short)0);
				urd.save(ur);
			}
		}
		initRelation();
		return judgement = true;
	}


  	public boolean removeRelation(String[] otherid){
  		boolean  judgement = false;
		if (otherid != null && otherid.length > 0 ) {
			String otherids = "";
			for (int i = 0; i < otherid.length; i++) {
				otherids = otherids + otherid[i];
				
				if (i < otherid.length - 1) {
					otherids = otherids + ",";
				}
			}
		Map session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		String myid = user.getId().toString();
		urd.removeRelation(myid, otherids);
		}
		initRelation();
		return judgement = true;
	}

}
