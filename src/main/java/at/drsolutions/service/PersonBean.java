package at.drsolutions.service;

import java.util.List;

import javax.persistence.EntityManager;

import at.drsolutions.dto.PersonSelectDto;
import at.drsolutions.persistence.Person;
import at.drsolutions.service.local.PersonBeanLocal;
import at.drsolutions.ws.mapper.PersonMapper;

public class PersonBean extends AbstractBean implements PersonBeanLocal {
	private static final long serialVersionUID = 1L;

	public PersonBean() {
	}

	public PersonBean(EntityManager em) {
		super(em);
	}

	@Override
	public List<PersonSelectDto> getAllPersonSelect() {
		return PersonMapper.mapToSelectDtoList(em.createNamedQuery(Person.FIND_ALL, Person.class).getResultList());
	}

}
