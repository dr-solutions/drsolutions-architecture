package at.drsolutions.ws.interfaces;

import javax.ws.rs.core.Response;

import at.drsolutions.dto.PersonDto;

public interface PersonService {

	public Response getAllPersonenSelect();

	public Response getAllPersonen();

	public Response saveOrUpdatePerson(PersonDto person);

	public Response saveOrUpdatePersonList(String json);

	public Response deletePerson(Integer id);

}
