package at.drsolutions.ws.impl;

import java.util.Random;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.dto.RandomIntegerInput;
import at.drsolutions.dto.RandomIntegerOutput;
import at.drsolutions.ws.interfaces.BackendService;

@WebService(endpointInterface = "at.drsolutions.ws.interfaces.BackendService")
public class BackendServiceImpl implements BackendService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BackendServiceImpl.class);

	public RandomIntegerOutput generateRandomInteger(RandomIntegerInput max) {
		if(max != null && max.getMaxValue() != null) {
			int intToReturn = new Random().nextInt(max.getMaxValue().intValue());
			LOGGER.info("BackendServiceImpl generated Integer --> " + intToReturn);
			return new RandomIntegerOutput(intToReturn);
		} else {
			return new RandomIntegerOutput(0);
		}
	}
}
