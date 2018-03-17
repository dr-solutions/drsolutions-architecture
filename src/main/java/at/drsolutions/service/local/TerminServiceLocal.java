package at.drsolutions.service.local;

import java.util.List;

import at.drsolutions.dto.TerminDto;

public interface TerminServiceLocal {
	List<TerminDto> getAllTermine();

	List<TerminDto> saveOrUpdate(TerminDto termin);

	List<TerminDto> saveOrUpdate(List<TerminDto> termin);

	List<TerminDto> remove(Integer id);
}
