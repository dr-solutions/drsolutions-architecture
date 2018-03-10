package at.drsolutions.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiceDAO {

	private static EntityManager em;

	static {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("drsolutions");
		em = emfactory.createEntityManager();
		em.getTransaction().begin();
	};

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return em;
	}
}
