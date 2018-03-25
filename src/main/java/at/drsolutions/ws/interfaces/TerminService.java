package at.drsolutions.ws.interfaces;

import javax.ws.rs.core.Response;

import at.drsolutions.dto.TerminDto;

public interface TerminService {

	public Response getAllTermine();

	public Response saveOrUpdateTermin(TerminDto termin);

	public Response saveOrUpdateTerminList(String json);

	public Response deleteTermin(Integer id);
}
