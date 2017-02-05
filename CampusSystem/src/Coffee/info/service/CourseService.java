package Coffee.info.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Coffee.info.dao.User;
import Coffee.info.dao.UserCourese;
import Coffee.info.dao.UserCoureseDAO;

import com.opensymphony.xwork2.ActionContext;

public class CourseService {
	private UserCoureseDAO ucd;

	public UserCoureseDAO getUcd() {
		return ucd;
	}

	public void setUcd(UserCoureseDAO ucd) {
		this.ucd = ucd;
	}

	public void doCourseInit() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		int userid = user.getId();
		String role = user.getRole();
		if (role != null && !role.equals("")) {
			if (role.equals("user")) {
				List courseList = ucd.findByUserid(userid);
				session.put("courselist", courseList);
			}else if(role.equals("admin")){
				List adminCourseList = new ArrayList();
				List courseList = ucd.getCourse();
				if (courseList != null && courseList.size()>0) {
					for (int i = 0; i < courseList.size(); i++) {
						Object[] obj = (Object[])courseList.get(i);
						UserCourese uc = new UserCourese();
						//uc.id, u.username, uc.course, uc.credit, uc.state
						uc.setId((Integer)obj[0]);
						uc.setUserid((Integer)obj[1]);
						uc.setUsername((String)obj[2]);
						uc.setCourse((String)obj[3]);
						uc.setCredit((Short)obj[4]);
						uc.setState((Short)obj[5]);
						String key = obj[1]+"_"+uc.getCourse();
						//System.out.println(key);
						uc.setKey(key);
						adminCourseList.add(uc);
					}
				}
				session.put("courselist", adminCourseList);
			}
		}
	}

	public void doChooseCourse(String[] course_credit) {
		UserCourese uc = new UserCourese();
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (course_credit != null && course_credit.length > 0) {
			for (int i = 0; i < course_credit.length; i++) {
				String cc = course_credit[i];
				String[] c_c = cc.split("_");
				int userid = user.getId();
				uc.setUserid(userid);
				uc.setCourse(c_c[0]);
				uc.setCredit(Short.parseShort(c_c[1]));
				short state = 0;
				uc.setState(state);
				if (ucd.getUsercoures(userid, c_c[0])) {
					System.out.println("课程已选，请勿重复选课！");
				} else {
					ucd.save(uc);
				}

			}
		}
		doCourseInit();

	}
	public void doPassOrUnPassCourse(String[] userid_course, Short state){
		//[2_高等数学,3_商务英语,2_商务英语]
		
		/*for (int i = 0; i < userid_course.length; i++) {
			String uc = userid_course[i];
			String[] u_c = uc.split("_");
			String userid = u_c[0];	
			String course = u_c[1];
		}
		
		
		//
		ucd.updateState(userid, course, state);*/		
		Map map = new HashMap();
		if (userid_course != null && userid_course.length > 0) {
			for (int i = 0; i < userid_course.length; i++) {
				//System.out.println(userid_course[i]);
				String userid = userid_course[i].split("_")[0];
				String coursename = userid_course[i].split("_")[1];
				// dao.updateCourseStateByUseridAndCourseName(userid,
				// coursename);
				map.put(coursename, coursename);
			}

			Set set = map.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				List list = new ArrayList();
				String course = (String) it.next();
				for (int i = 0; i < userid_course.length; i++) {
					String coursename = userid_course[i].split("_")[1];
					if (course.equals(coursename)) {
						list.add(userid_course[i]);
					}
				}

				Object[] obj = list.toArray();
				String[] str = new String[obj.length];
				for (int i = 0; i < obj.length; i++) {
					str[i] = obj[i].toString();
				}
				String userid = "";
				if (str!=null && str.length>0) {
					for (int i = 0; i < str.length; i++) {
						userid = userid +"'"+str[i].split("_")[0]+"'";
						if (i<(str.length-1)) {
							userid = userid + ",";
						}
					}	
				}
				
				//System.out.println(userid);
				
				ucd.updateState(userid, course, state);

			}

		}
		doCourseInit();
		
	}
}
