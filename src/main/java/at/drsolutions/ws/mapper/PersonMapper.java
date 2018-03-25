package at.drsolutions.ws.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import at.drsolutions.dto.PersonSelectDto;
import at.drsolutions.persistence.Person;

public class PersonMapper {

	public static Person mapToEntity(PersonSelectDto dto, EntityManager em) {
		return em.find(Person.class, dto.getValue());
	}

	public static Set<Person> mapToEntityList(List<PersonSelectDto> personen, EntityManager em) {
		return personen != null ? personen.stream().map(person -> mapToEntity(person, em)).collect(Collectors.toSet())
				: new HashSet<>();
	}

	public static PersonSelectDto mapToSelectDto(Person entity) {
		return new PersonSelectDto(entity.getId(), entity.getLabel());
	}

	public static List<PersonSelectDto> mapToSelectDtoList(Set<Person> personen) {
		return personen != null ? personen.stream().map(person -> mapToSelectDto(person)).collect(Collectors.toList())
				: new ArrayList<>();
	}
}
