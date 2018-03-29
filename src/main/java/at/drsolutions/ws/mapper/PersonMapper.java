package at.drsolutions.ws.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import at.drsolutions.dto.PersonDto;
import at.drsolutions.dto.PersonSelectDto;
import at.drsolutions.dto.TerminDto;
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

	public static List<PersonSelectDto> mapToSelectDtoList(Collection<Person> personen) {
		return personen != null ? personen.stream().map(person -> mapToSelectDto(person)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	// Map PersonDto to Person without Termine
	public static Person mapToEntity(PersonDto dto) {
		return new Person(dto.getId(), dto.getVorname(), dto.getNachname(), dto.getMail(), dto.getTelefon(), null);
	}

	public static List<Person> mapToEntityList(List<PersonDto> personen) {
		return personen != null ? personen.stream().map(person -> mapToEntity(person)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static PersonDto mapToDto(Person entity) {
		return new PersonDto(entity.getId(), entity.getVorname(), entity.getNachname(), entity.getMail(),
				entity.getTelefon());
	}

	public static List<PersonDto> mapToDtoList(List<Person> personen) {
		return personen != null ? personen.stream().map(person -> mapToDto(person)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static String mapToSelectedOutputString(List<PersonSelectDto> personen) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(personen);
		} catch (IOException e) {
			return "";
		}
	}

	public static String mapToOutputString(List<PersonDto> personen) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(personen);
		} catch (IOException e) {
			return "";
		}
	}

	public static List<PersonDto> mapToInputDtoList(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<TerminDto>>() {
			});
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}
}
