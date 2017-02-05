package Coffee.info.dao;

/**
 * UserCourese entity. @author MyEclipse Persistence Tools
 */

public class UserCourese implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private String course;
	private Short credit;
	private Short state;
	private String username;
	private String key;

	// Constructors

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/** default constructor */
	public UserCourese() {
	}

	/** full constructor */
	public UserCourese(Integer userid, String course, Short credit, Short state, String username, String key) {
		this.userid = userid;
		this.course = course;
		this.credit = credit;
		this.state = state;
		this.username = username;
		this.key = key;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Short getCredit() {
		return this.credit;
	}

	public void setCredit(Short credit) {
		this.credit = credit;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}