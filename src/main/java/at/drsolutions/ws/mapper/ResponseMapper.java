package at.drsolutions.ws.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ResponseMapper {

	public static Response erzeugeResponseOk(String message) {
		return Response.ok(message) //
				.header("Access-Control-Allow-Origin", "*") //
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	public static Response erzeugeResponseFehler(String message, Status status) {
		return Response.status(status).header("Access-Control-Allow-Origin", "*") //
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(message)
				.build();
	}
}
