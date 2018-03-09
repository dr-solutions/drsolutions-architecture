package at.drsolutions.ws.impl;

import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.dto.RandomIntegerOutput;
import at.drsolutions.dto.TerminOutput;
import at.drsolutions.service.TerminService;
import at.drsolutions.service.local.TerminServiceLocal;
import at.drsolutions.ws.interfaces.BackendService;
import at.drsolutions.ws.mapper.RandomIntegerMapper;
import at.drsolutions.ws.mapper.ResponseMapper;
import at.drsolutions.ws.mapper.TerminMapper;

@Path("/backendService")
public class BackendServiceImpl implements BackendService {
	private static Logger LOGGER = LoggerFactory.getLogger(BackendServiceImpl.class);
	private RandomIntegerMapper randomIntegerMapper = new RandomIntegerMapper();
	private TerminMapper terminMapper = new TerminMapper();

	// http://localhost:8080/dr-solutions/rest/backendService/generateRandomIntegerText?max=1001
	@GET
	@Produces({ "application/json" })
	@Path("/generateRandomIntegerText")
	public Response generateRandomIntegerText(@QueryParam("max") int max) {
		int intToReturn = new Random().nextInt(max);
		LOGGER.info("BackendServiceImpl generated Integer --> " + intToReturn);
		String toReturn = randomIntegerMapper.mapToOutputString(new RandomIntegerOutput(intToReturn));
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	// http://localhost:8080/dr-solutions/rest/backendService/getAllTermine
	@Override
	@GET
	@Produces({ "application/json" })
	@Path("/getAllTermine")
	public Response getAllTermine() {
		TerminServiceLocal terminService = new TerminService();
		List<TerminOutput> termine = terminService.getAllTermine();
		String toReturn = terminMapper.mapToOutputString(termine);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}
}
