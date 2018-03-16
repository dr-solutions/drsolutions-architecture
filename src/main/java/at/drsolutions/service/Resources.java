package at.drsolutions.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Resources {

	@Produces
	@PersistenceContext(unitName = "drsolutions")
	private static EntityManager em;
}
