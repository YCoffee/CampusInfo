package Coffee.info.control;

import Coffee.info.service.CourseService;

public class CourseAction {
	private CourseService courseSerivce;
	private String[] course_key;
	
	public String[] getCourse_key() {
		return course_key;
	}

	public void setCourse_key(String[] courseKey) {
		course_key = courseKey;
	}

	public CourseService getCourseSerivce() {
		return courseSerivce;
	}

	public void setCourseSerivce(CourseService courseSerivce) {
		this.courseSerivce = courseSerivce;
	}

	public String doInitCourseAction(){
		courseSerivce.doCourseInit();
		return "success";
	}
	public String doChooseCourseAction(){
		courseSerivce.doChooseCourse(course_key);
		return "success";
	}
	public String doAdminCourseAction(){
		courseSerivce.doCourseInit();
		return "success";
	}
	public String dopassAction(){
		//'状态：0-在读、1-重修、2-合格、3-不合格',
		Short state = 2;
		courseSerivce.doPassOrUnPassCourse(course_key, state);
		//清除数组内容防止未选提交
		course_key = null;
		return "success";
	}
	public String doUnpassAction(){
		//'状态：0-在读、1-重修、2-合格、3-不合格',
		Short state = 3;
		courseSerivce.doPassOrUnPassCourse(course_key, state);
		//清除数组内容防止未选提交
		course_key = null;
		return "success";
	}
}
