package at.drsolutions.interceptor;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.exception.TerminActionExcpetion;
import at.drsolutions.ws.mapper.ResponseMapper;

@Provider
public class ExceptionInterceptor implements ExceptionMapper<Throwable> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionInterceptor.class);

	@Override
	public Response toResponse(Throwable exception) {

		if (exception instanceof TerminActionExcpetion) {
			return ResponseMapper.erzeugeResponseFehler(exception.getMessage(), Status.INTERNAL_SERVER_ERROR);
		} else {
			String message = "Unerwarteter Fehler!";
			LOGGER.error(message, exception);
			String responseMessage = extractAndAppendExceptioninfo(message, exception);
			return ResponseMapper.erzeugeResponseFehler(responseMessage, Status.INTERNAL_SERVER_ERROR);
		}
	}

	private String extractAndAppendExceptioninfo(String message, Throwable exception) {
		StringBuilder builder = new StringBuilder(message);
		builder.append(
				exception != null && exception.getClass() != null ? " " + exception.getClass().getName() + " ->" : "");
		builder.append(exception != null ? " " + exception.getMessage() : "");
		return builder.toString();
	}
}
