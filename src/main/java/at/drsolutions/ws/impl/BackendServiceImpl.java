package at.drsolutions.ws.impl;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.dto.RandomIntegerOutput;
import at.drsolutions.dto.TerminOutput;
import at.drsolutions.service.local.TerminServiceLocal;
import at.drsolutions.ws.interfaces.BackendService;
import at.drsolutions.ws.mapper.RandomIntegerMapper;
import at.drsolutions.ws.mapper.TerminMapper;

@Stateless
@Path("/backendService")
public class BackendServiceImpl implements BackendService {
	private static Logger LOGGER = LoggerFactory.getLogger(BackendServiceImpl.class);
	private RandomIntegerMapper randomIntegerMapper = new RandomIntegerMapper();
	private TerminMapper terminMapper = new TerminMapper();

	@Inject
	TerminServiceLocal terminService;

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

	@Override
	@GET
	@Produces({ "application/json" })
	@Path("/getAllTermine")
	public Response getAllTermine() {
		List<TerminOutput> termine = terminService.getAllTermine();
		String toReturn = terminMapper.mapToOutputString(termine);
		return Response.ok(toReturn) //
				.header("Access-Control-Allow-Origin", "*") //
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

}
