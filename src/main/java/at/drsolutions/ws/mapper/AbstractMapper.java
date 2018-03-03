package at.drsolutions.ws.mapper;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;

public abstract class AbstractMapper<I, O> {

	private ObjectMapper mapper = new ObjectMapper();

	private static final String EMPTY = "";

	public abstract Class<I> getInputObjectClass();

	public abstract Class<O> getOutputObjectClass();

	public abstract Logger getLogger();

	public I mapToInputObject(String jsonString) {
		try {
			return mapper.readValue(jsonString, getInputObjectClass());
		} catch (IOException e) {
			getLogger().error("Fehler beim Mappen des spezifischen Input-DTOs!", e);
			return null;
		}
	}

	public String mapToOutputString(O objToMap) {
		try {
			return mapper.writeValueAsString(objToMap);
		} catch (IOException e) {
			getLogger().error("Fehler beim Mappen des spezifischen Output-String!", e);
			return EMPTY;
		}
	}

	public String mapToInputString(I objToMap) {
		try {
			return mapper.writeValueAsString(objToMap);
		} catch (IOException e) {
			getLogger().error("Fehler beim Mappen des spezifischen Input-String!", e);
			return EMPTY;
		}
	}

	public O mapToOutputObject(String jsonString) {
		try {
			return mapper.readValue(jsonString, getOutputObjectClass());
		} catch (IOException e) {
			getLogger().error("Fehler beim Mappen des spezifischen Output-DTOs!", e);
			return null;
		}
	}
}
