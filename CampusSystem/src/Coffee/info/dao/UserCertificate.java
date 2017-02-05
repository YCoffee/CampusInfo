package Coffee.info.dao;

/**
 * UserCertificate entity. @author MyEclipse Persistence Tools
 */

public class UserCertificate implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private String cetificate;
	private String level;
	private Short state;

	// Constructors

	/** default constructor */
	public UserCertificate() {
	}

	/** full constructor */
	public UserCertificate(Integer userid, String cetificate, String level,
			Short state) {
		this.userid = userid;
		this.cetificate = cetificate;
		this.level = level;
		this.state = state;
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

	public String getCetificate() {
		return this.cetificate;
	}

	public void setCetificate(String cetificate) {
		this.cetificate = cetificate;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}