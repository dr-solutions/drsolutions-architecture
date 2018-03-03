package at.drsolutions.ws.impl;

import java.util.Random;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.dto.RandomIntegerInput;
import at.drsolutions.dto.RandomIntegerOutput;
import at.drsolutions.ws.interfaces.BackendService;
import at.drsolutions.ws.mapper.RandomIntegerMapper;

@WebService(endpointInterface = "at.drsolutions.ws.interfaces.BackendService")
public class BackendServiceImpl implements BackendService {

	private static Logger LOGGER = LoggerFactory.getLogger(BackendServiceImpl.class);
	private RandomIntegerMapper randomIntegerMapper = new RandomIntegerMapper();

	public String generateRandomInteger(String max) {
		if (max != null && !max.trim().isEmpty()) {
			RandomIntegerInput input = randomIntegerMapper.mapToInputObject(max);

			if (input != null && input.getMaxValue() != null) {
				int intToReturn = new Random().nextInt(input.getMaxValue().intValue());
				LOGGER.info("BackendServiceImpl generated Integer --> " + intToReturn);
				return randomIntegerMapper.mapToOutputString(new RandomIntegerOutput(intToReturn));
			}
		}
		return randomIntegerMapper.mapToOutputString(new RandomIntegerOutput(0));
	}
}
