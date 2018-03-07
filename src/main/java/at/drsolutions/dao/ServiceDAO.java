package at.drsolutions.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ServiceDAO {

	@PersistenceContext(unitName = "drsolutions")
	private EntityManager em;

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
}
