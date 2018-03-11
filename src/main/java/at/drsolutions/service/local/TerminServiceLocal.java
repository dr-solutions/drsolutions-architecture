package at.drsolutions.service.local;

import java.util.List;

import at.drsolutions.dto.TerminDto;

public interface TerminServiceLocal {
	public List<TerminDto> getAllTermine();

	public List<TerminDto> saveOrUpdate(TerminDto termin);

	public List<TerminDto> saveOrUpdate(List<TerminDto> termin);
}
