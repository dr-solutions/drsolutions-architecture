package at.drsolutions.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BackendService {

	@WebMethod
	public int generateRandomInteger(int max);
}
