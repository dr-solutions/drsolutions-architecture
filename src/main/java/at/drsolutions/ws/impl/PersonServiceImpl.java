package at.drsolutions.ws.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		String toReturn = PersonMapper.mapToOutputString(personen);
		return ResponseMapper.erzeugeResponseOk(toReturn);
	}
}
