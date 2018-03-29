package at.drsolutions.ws.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.drsolutions.dto.TerminDto;
import at.drsolutions.service.TerminBean;
import at.drsolutions.service.local.TerminBeanLocal;
import at.drsolutions.ws.interfaces.TerminService;
import at.drsolutions.ws.mapper.ResponseMapper;
import at.drsolutions.ws.mapper.TerminMapper;

//http://localhost:8080/dr-solutions/rest/terminService/[methodname]
@Path("/terminService")
public class TerminServiceImpl implements TerminService {

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllTermine")
	public Response getAllTermine() {
		TerminBeanLocal terminService = new TerminBean();
		List<TerminDto> termine = terminService.getAllTermine();
		String toReturn = TerminMapper.mapToOutputString(termine);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveOrUpdateTermin")
	public Response saveOrUpdateTermin(TerminDto termin) {
		TerminBeanLocal terminService = new TerminBean();
		termin.setOrt("Leoben");
		List<TerminDto> termine = terminService.saveOrUpdate(termin);
		String toReturn = TerminMapper.mapToOutputString(termine);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveOrUpdateTerminList")
	public Response saveOrUpdateTerminList(String json) {
		TerminBeanLocal terminService = new TerminBean();
		List<TerminDto> termineToSave = TerminMapper.mapToInputDtoList(json);
		List<TerminDto> termine = terminService.saveOrUpdate(termineToSave);
		String toReturn = TerminMapper.mapToOutputString(termine);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteTermin")
	public Response deleteTermin(Integer id) {
		TerminBeanLocal terminService = new TerminBean();
		List<TerminDto> termine = terminService.remove(id);
		String toReturn = TerminMapper.mapToOutputString(termine);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}
}
