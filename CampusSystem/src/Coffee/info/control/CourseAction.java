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
		//'״̬��0-�ڶ���1-���ޡ�2-�ϸ�3-���ϸ�',
		Short state = 2;
		courseSerivce.doPassOrUnPassCourse(course_key, state);
		//����������ݷ�ֹδѡ�ύ
		course_key = null;
		return "success";
	}
	public String doUnpassAction(){
		//'״̬��0-�ڶ���1-���ޡ�2-�ϸ�3-���ϸ�',
		Short state = 3;
		courseSerivce.doPassOrUnPassCourse(course_key, state);
		//����������ݷ�ֹδѡ�ύ
		course_key = null;
		return "success";
	}
}
