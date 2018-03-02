package at.drsolutions.ws;

import java.util.Random;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(endpointInterface = "at.drsolutions.ws.BackendService")
public class BackendServiceImpl implements BackendService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BackendServiceImpl.class);

	public int generateRandomInteger(int max) {
		int intToReturn = new Random().nextInt(max);
		LOGGER.info("BackendServiceImpl generated Integer --> " + intToReturn);
		return intToReturn;
	}
}
