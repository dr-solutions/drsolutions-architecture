package at.drsolutions.ws.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class BackendServiceApp extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public BackendServiceApp() {
		singletons.add(new BackendServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
