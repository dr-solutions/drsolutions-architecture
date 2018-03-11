package at.drsolutions.dao;

import java.util.List;

import at.drsolutions.persistence.Termin;

public class TerminDAO extends ServiceDAO {

	public List<Termin> getAllTermine() {
		// throw new RuntimeException("Exception beim Lesen der Termine :(");
		return getEntityManager().createNamedQuery(Termin.FIND_ALL, Termin.class).getResultList();
	}

	public List<Termin> saveOrUpdate(Termin termin) {
		if (termin != null) {
			// Save new Temrin (save)
			if (termin.getId() == null) {
				getEntityManager().persist(termin);
			}
			// Save existing Temrin (update)
			else {
				getEntityManager().merge(termin);
			}
			getEntityManager().flush();
		}
		return getAllTermine();
	}

	public List<Termin> saveOrUpdateList(List<Termin> termine) {
		if (termine != null && !termine.isEmpty()) {
			for (Termin termin : termine) {
				saveOrUpdate(termin);
			}
		}
		return getAllTermine();
	}
}
