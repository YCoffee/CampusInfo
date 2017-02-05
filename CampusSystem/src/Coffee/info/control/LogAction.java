package Coffee.info.control;

import Coffee.info.service.LogServic;

public class LogAction {
	private LogServic logServic;

	public LogServic getLogServic() {
		return logServic;
	}

	public void setLogServic(LogServic logServic) {
		this.logServic = logServic;
	}

	public String Dolog() {
		String mess = logServic.Dolog();

		return mess;
	}
}
