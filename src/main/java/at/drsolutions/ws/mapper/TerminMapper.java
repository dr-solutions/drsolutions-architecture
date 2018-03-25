package at.drsolutions.ws.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import at.drsolutions.dto.TerminDto;
import at.drsolutions.persistence.Termin;

public class TerminMapper {

	public static Termin mapToEntity(TerminDto dto) {
		return new Termin(dto.getId(), dto.getBezeichnung(), dto.getOrt(), dto.getZeitpunkt(),
				PersonMapper.mapToEntityList(dto.getBeteiligtePersonen()));
	}

	public static TerminDto mapToDto(Termin entity) {
		return new TerminDto(entity.getId(), entity.getBezeichnung(), entity.getOrt(), entity.getZeitpunkt(),
				PersonMapper.mapToSelectDtoList(entity.getPersonen()));
	}

	public static List<Termin> mapToEntityList(List<TerminDto> outputs) {
		return outputs != null ? outputs.stream().map(output -> mapToEntity(output)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static List<TerminDto> mapToDtoList(List<Termin> termine) {
		return termine != null ? termine.stream().map(termin -> mapToDto(termin)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public String mapToOutputString(List<TerminDto> termine) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(termine);
		} catch (IOException e) {
			return "";
		}
	}

	public String mapToOutputString(TerminDto termine) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(termine);
		} catch (IOException e) {
			return "";
		}
	}

	public TerminDto mapToInputDto(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, TerminDto.class);
		} catch (IOException e) {
			return null;
		}
	}

	public List<TerminDto> mapToInputDtoList(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<TerminDto>>() {
			});
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}
}
