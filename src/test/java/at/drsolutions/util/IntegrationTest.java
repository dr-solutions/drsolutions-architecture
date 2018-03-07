package at.drsolutions.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;

public abstract class IntegrationTest<T> {

	private static EntityManager em;
	public T testedObject;

	static {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("drsolutions_test");
		em = emfactory.createEntityManager();
		em.getTransaction().begin();
	};

	public abstract T newInstance();

	@Before
	public void initTestedObject() {
		testedObject = newInstance();
	}

	public EntityManager getEntityManager() {
		return em;
	}
}
