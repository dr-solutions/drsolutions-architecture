package at.drsolutions.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BackendWebserviceIT {
	
	private BackendService backendService;
	
	@Before
	public void initWebserviceClient() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/drsolutions-architecture-1.0-SNAPSHOT/BackendServiceImpl?wsdl");
        QName qname = new QName("http://ws.drsolutions.at/", "BackendServiceImplService");
        Service service = Service.create(url, qname);
        backendService = service.getPort(BackendService.class);
	}

	@Test
	public void testBackendWebserviceCall() {
		int max = 1001;
		int intFromWS = backendService.generateRandomInteger(max);
		System.out.println("Integer got from Backend-Webservice (max="+ max + ") --> " + intFromWS);
		Assert.assertTrue(intFromWS >= 0 && intFromWS <= max);
	}
}
