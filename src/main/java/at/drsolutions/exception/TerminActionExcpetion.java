package at.drsolutions.exception;

import javax.ws.rs.WebApplicationException;

public class TerminActionExcpetion extends WebApplicationException {
	private static final long serialVersionUID = 1L;

	public TerminActionExcpetion(String message) {
		super(message);
	}
}
