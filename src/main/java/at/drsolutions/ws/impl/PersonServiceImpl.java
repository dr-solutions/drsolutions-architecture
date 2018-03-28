package at.drsolutions.ws.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.drsolutions.dto.PersonDto;
import at.drsolutions.dto.PersonSelectDto;
import at.drsolutions.service.PersonBean;
import at.drsolutions.service.local.PersonBeanLocal;
import at.drsolutions.ws.interfaces.PersonService;
import at.drsolutions.ws.mapper.PersonMapper;
import at.drsolutions.ws.mapper.ResponseMapper;

//http://localhost:8080/dr-solutions/rest/personService/[methodname]
@Path("/personService")
public class PersonServiceImpl implements PersonService {

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllPersonenSelect")
	public Response getAllPersonenSelect() {
		PersonBeanLocal personBean = new PersonBean();
		List<PersonSelectDto> personen = personBean.getAllPersonSelect();
		String toReturn = PersonMapper.mapToSelectedOutputString(personen);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllPersonen")
	public Response getAllPersonen() {
		PersonBeanLocal personenService = new PersonBean();
		List<PersonDto> personen = personenService.getAllPersonen();
		String toReturn = PersonMapper.mapToOutputString(personen);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveOrUpdatePerson")
	public Response saveOrUpdatePerson(PersonDto person) {
		PersonBeanLocal personService = new PersonBean();
		List<PersonDto> personen = personService.saveOrUpdate(person);
		String toReturn = PersonMapper.mapToOutputString(personen);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveOrUpdatePersonList")
	public Response saveOrUpdatePersonList(String json) {
		PersonBeanLocal personService = new PersonBean();
		List<PersonDto> personenToSave = PersonMapper.mapToInputDtoList(json);
		List<PersonDto> personen = personService.saveOrUpdate(personenToSave);
		String toReturn = PersonMapper.mapToOutputString(personen);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deletePerson")
	public Response deletePerson(Integer id) {
		PersonBeanLocal personenService = new PersonBean();
		List<PersonDto> personen = personenService.remove(id);
		String toReturn = PersonMapper.mapToOutputString(personen);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}
}
