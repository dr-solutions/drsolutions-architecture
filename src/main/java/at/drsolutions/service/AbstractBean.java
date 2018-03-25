package at.drsolutions.service;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	EntityManager em;

	public AbstractBean() {
		em = Persistence.createEntityManagerFactory("drsolutions").createEntityManager();
		em.getTransaction().begin();
	}

	public AbstractBean(EntityManager em) {
		this.em = em;
	}
}
