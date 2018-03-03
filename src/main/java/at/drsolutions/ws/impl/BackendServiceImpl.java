package at.drsolutions.ws.impl;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.dto.RandomIntegerOutput;
import at.drsolutions.ws.interfaces.BackendService;
import at.drsolutions.ws.mapper.RandomIntegerMapper;

@Path("/backendService")
public class BackendServiceImpl implements BackendService {
	private static Logger LOGGER = LoggerFactory.getLogger(BackendServiceImpl.class);
	private RandomIntegerMapper randomIntegerMapper = new RandomIntegerMapper();

	@GET
	@Produces({ "application/json" })
	@Path("/generateRandomIntegerText")
	public Response generateRandomIntegerText(@QueryParam("max") int max) {
		int intToReturn = new Random().nextInt(max);
		LOGGER.info("BackendServiceImpl generated Integer --> " + intToReturn);
		String toReturn = randomIntegerMapper.mapToOutputString(new RandomIntegerOutput(intToReturn));
		return Response.ok(toReturn) //
				.header("Access-Control-Allow-Origin", "*") //
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	// public String generateRandomInteger(String max) {
	// if (max != null && !max.trim().isEmpty()) {
	// RandomIntegerInput input = randomIntegerMapper.mapToInputObject(max);
	//
	// if (input != null && input.getMaxValue() != null) {
	// int intToReturn = new Random().nextInt(input.getMaxValue().intValue());
	// LOGGER.info("BackendServiceImpl generated Integer --> " + intToReturn);
	// return randomIntegerMapper.mapToOutputString(new
	// RandomIntegerOutput(intToReturn));
	// }
	// }
	// return randomIntegerMapper.mapToOutputString(new RandomIntegerOutput(0));
	// }
}
