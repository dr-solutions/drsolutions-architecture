package at.drsolutions.ws.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jackson.map.ObjectMapper;

import at.drsolutions.dto.TerminOutput;
import at.drsolutions.persistence.Termin;

public class TerminMapper {

	public static Termin mapToEntity(TerminOutput output) {
		return new Termin(output.getId(), output.getBezeichnung(), output.getBeteiligtePersonen(),
				output.getZeitpunt());
	}

	public static TerminOutput mapToDto(Termin entity) {
		return new TerminOutput(entity.getId(), entity.getBezeichnung(), entity.getBeteiligtePersonen(),
				entity.getZeitpunt());
	}

	public static List<Termin> mapToEntityList(List<TerminOutput> outputs) {
		return outputs != null ? outputs.stream().map(output -> mapToEntity(output)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static List<TerminOutput> mapToDtoList(List<Termin> termine) {
		return termine != null ? termine.stream().map(termin -> mapToDto(termin)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public String mapToOutputString(List<TerminOutput> termine) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(termine);
		} catch (IOException e) {
			return "";
		}
	}
}
