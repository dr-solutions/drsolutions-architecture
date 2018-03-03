package at.drsolutions.ws.interfaces;

import javax.ws.rs.core.Response;

public interface BackendService {

	public Response generateRandomIntegerText(int max);

}
