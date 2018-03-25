package at.drsolutions.ws.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import at.drsolutions.dto.PersonSelectDto;
import at.drsolutions.persistence.Person;

public class PersonMapper {

	public static Person mapToEntity(PersonSelectDto dto) {
		return new Person();
	}

	public static Set<Person> mapToEntityList(List<PersonSelectDto> personen) {
		return personen != null ? personen.stream().map(person -> mapToEntity(person)).collect(Collectors.toSet())
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
