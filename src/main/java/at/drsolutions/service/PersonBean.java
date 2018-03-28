package at.drsolutions.service;

import java.util.List;

import javax.persistence.EntityManager;

import at.drsolutions.dto.PersonDto;
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

	@Override
	public List<PersonDto> getAllPersonen() {
		return PersonMapper.mapToDtoList(em.createNamedQuery(Person.FIND_ALL, Person.class).getResultList());
	}

	@Override
	public List<PersonDto> saveOrUpdate(PersonDto person) {
		if (person != null) {
			Person entity = PersonMapper.mapToEntity(person);
			// Save new Person (save)
			if (entity.getId() == null) {
				em.persist(entity);
			}
			// Save existing Person (update)
			else {
				em.merge(entity);
			}
			em.flush();
			em.getTransaction().commit();
			beginTransactionIfNotActive();
		}
		return getAllPersonen();
	}

	@Override
	public List<PersonDto> saveOrUpdate(List<PersonDto> personen) {
		if (personen != null && !personen.isEmpty()) {
			for (PersonDto dto : personen) {
				saveOrUpdate(dto);
			}
		}
		return getAllPersonen();
	}

	@Override
	public List<PersonDto> remove(Integer id) {
		if (id != null) {
			Person person = em.find(Person.class, id);
			if (person != null) {
				em.remove(person);
				em.flush();
				em.getTransaction().commit();
				beginTransactionIfNotActive();
			}
		}
		return getAllPersonen();
	}

	private void beginTransactionIfNotActive() {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
	}
}
