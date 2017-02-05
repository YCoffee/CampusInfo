package Coffee.info.dao;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable {

	// Fields

	private String logDate;
	private String logLevel;
	private String location;
	private String message;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(String logDate, String logLevel, String location, String message) {
		this.logDate = logDate;
		this.logLevel = logLevel;
		this.location = location;
		this.message = message;
	}

	// Property accessors

	public String getLogDate() {
		return this.logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getLogLevel() {
		return this.logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}