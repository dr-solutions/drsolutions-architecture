package at.drsolutions.service.local;

import java.util.List;

import at.drsolutions.dto.PersonDto;
import at.drsolutions.dto.PersonSelectDto;

public interface PersonBeanLocal {
	List<PersonSelectDto> getAllPersonSelect();

	List<PersonDto> getAllPersonen();

	List<PersonDto> saveOrUpdate(PersonDto person);

	List<PersonDto> saveOrUpdate(List<PersonDto> personen);

	List<PersonDto> remove(Integer id);
}
