package at.drsolutions.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.drsolutions.dto.RandomIntegerInput;
import at.drsolutions.dto.RandomIntegerOutput;
import at.drsolutions.ws.interfaces.BackendService;
import at.drsolutions.ws.mapper.RandomIntegerMapper;

public class BackendWebserviceIT {

	private BackendService backendService;
	private RandomIntegerMapper mapper = new RandomIntegerMapper();

	@Before
	public void initWebserviceClient() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/drsolutions-architecture-1.0-SNAPSHOT/BackendServiceImpl?wsdl");
		QName qname = new QName("http://impl.ws.drsolutions.at/", "BackendServiceImplService");
		Service service = Service.create(url, qname);
		backendService = service.getPort(BackendService.class);
	}

	@Test
	public void testBackendWebserviceCall() {
		int max = 1001;
		String jsonInputString = mapper.mapToInputString(new RandomIntegerInput(max));
		System.out.println("JSON input String --> " + jsonInputString);

		String outputString = backendService.generateRandomInteger(jsonInputString);
		RandomIntegerOutput output = mapper.mapToOutputObject(outputString);

		Assert.assertNotNull(output);
		Assert.assertNotNull(output.getGeneratedInteger());
		int intFromWS = output.getGeneratedInteger().intValue();
		Assert.assertTrue(intFromWS >= 0 && intFromWS <= max);
		System.out.println("Integer got from Backend-Webservice (max=" + max + ") --> " + intFromWS);
	}
}
