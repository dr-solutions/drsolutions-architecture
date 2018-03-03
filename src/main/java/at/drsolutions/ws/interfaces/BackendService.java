package at.drsolutions.ws.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.drsolutions.dto.RandomIntegerInput;
import at.drsolutions.dto.RandomIntegerOutput;

@WebService
public interface BackendService {

	@WebMethod
	public RandomIntegerOutput generateRandomInteger(RandomIntegerInput max);
}
