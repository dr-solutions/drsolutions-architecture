package at.drsolutions.ws.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ResponseMapper {

	public static Response erzeugeResponseOk(String message) {
		return Response.ok(message) //
				.header("Access-Control-Allow-Origin", "*") //
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //
				.header("Access-Control-Allow-Headers", "content-type, X-PINGOTHER, Accept, X-Requested-With") //
				.header("Access-Control-Allow-Request-Headers", "content-type") //
				.header("Access-Control-Max-Age", "86400") //
				.build();
	}

	public static Response erzeugeResponseFehler(String message, Status status) {
		return Response.status(status) //
				.header("Access-Control-Allow-Origin", "*") //
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //
				.header("Access-Control-Allow-Headers", "content-type, Accept, X-Requested-With") //
				.header("Access-Control-Allow-Request-Headers", "content-type") //
				.header("Access-Control-Max-Age", "86400")//
				.entity(message) //
				.type("text/plain") //
				.build();
	}
}
