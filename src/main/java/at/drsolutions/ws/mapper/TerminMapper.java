package at.drsolutions.ws.mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import at.drsolutions.dto.TerminDto;
import at.drsolutions.persistence.Termin;

public class TerminMapper {

	private static final String DATE_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_ISO_8601, Locale.GERMANY);

	public static Termin mapToEntity(TerminDto dto, EntityManager em) {
		return new Termin(dto.getId(), dto.getBezeichnung(), dto.getOrt(), dto.getZeitpunkt(),
				PersonMapper.mapToEntityList(dto.getBeteiligtePersonen(), em));
	}

	public static TerminDto mapToDto(Termin entity) {
		return new TerminDto(entity.getId(), entity.getBezeichnung(), entity.getOrt(), entity.getZeitpunkt(),
				PersonMapper.mapToSelectDtoList(entity.getPersonen()));
	}

	public static List<Termin> mapToEntityList(List<TerminDto> outputs, EntityManager em) {
		return outputs != null ? outputs.stream().map(output -> mapToEntity(output, em)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static List<TerminDto> mapToDtoList(List<Termin> termine) {
		return termine != null ? termine.stream().map(termin -> mapToDto(termin)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static String mapToOutputString(List<TerminDto> termine) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(dateFormat);
			return mapper.writeValueAsString(termine);
		} catch (IOException e) {
			return "";
		}
	}

	public static List<TerminDto> mapToInputDtoList(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(dateFormat);
			return mapper.readValue(json, new TypeReference<List<TerminDto>>() {
			});
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}
}
