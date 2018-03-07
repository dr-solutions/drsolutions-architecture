package at.drsolutions.dao;

import java.util.List;

import at.drsolutions.persistence.Termin;

public class TerminDAO extends ServiceDAO {

	public List<Termin> getAllTermine() {
		return getEntityManager().createNamedQuery(Termin.FIND_ALL, Termin.class).getResultList();
	}
}
