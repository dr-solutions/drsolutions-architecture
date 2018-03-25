package at.drsolutions.ws.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/*")
public class BackendServiceApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public BackendServiceApplication() {
		singletons.add(new TerminServiceImpl());
		singletons.add(new PersonServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
