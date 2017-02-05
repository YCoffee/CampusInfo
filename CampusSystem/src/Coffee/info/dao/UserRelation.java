package Coffee.info.dao;

/**
 * UserRelation entity. @author MyEclipse Persistence Tools
 */

public class UserRelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myId;
	private Integer otherId;
	private String relateion;
	private Short state;
	private String otherName;

	// Constructors



	/** default constructor */
	public UserRelation() {
	}

	/** full constructor */
	public UserRelation(Integer myId, Integer otherId, String relateion,
			Short state, String otherName) {
		this.myId = myId;
		this.otherId = otherId;
		this.relateion = relateion;
		this.state = state;
		this.otherName = otherName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMyId() {
		return this.myId;
	}

	public void setMyId(Integer myId) {
		this.myId = myId;
	}

	public Integer getOtherId() {
		return this.otherId;
	}

	public void setOtherId(Integer otherId) {
		this.otherId = otherId;
	}

	public String getRelateion() {
		return this.relateion;
	}

	public void setRelateion(String relateion) {
		this.relateion = relateion;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}
	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
}