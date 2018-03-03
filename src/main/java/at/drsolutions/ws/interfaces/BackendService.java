package at.drsolutions.ws.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BackendService {

	@WebMethod
	public String generateRandomInteger(String max);
}
