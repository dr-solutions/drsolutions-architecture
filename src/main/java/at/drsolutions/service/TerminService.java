package at.drsolutions.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import at.drsolutions.dto.TerminDto;
import at.drsolutions.exception.TerminActionExcpetion;
import at.drsolutions.persistence.Termin;
import at.drsolutions.service.local.TerminServiceLocal;
import at.drsolutions.ws.mapper.TerminMapper;

@Named("terminService")
public class TerminService implements Serializable, TerminServiceLocal {
	private static final long serialVersionUID = 1L;

	EntityManager em;

	public TerminService() {
		em = Persistence.createEntityManagerFactory("drsolutions").createEntityManager();
		em.getTransaction().begin();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<TerminDto> getAllTermine() {
		return TerminMapper.mapToDtoList(em.createNamedQuery(Termin.FIND_ALL, Termin.class).getResultList());
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<TerminDto> saveOrUpdate(TerminDto termin) {
		if (termin != null) {

			// Test fuer Exceptionhandling
			if (termin.getBezeichnung() != null && termin.getBezeichnung().toLowerCase().contains("i bims")) {
				throw new TerminActionExcpetion("'I bims' darf nicht in der Berzeichnung vorkommen!");
			}

			Termin entity = TerminMapper.mapToEntity(termin);
			// Save new Temrin (save)
			if (entity.getId() == null) {
				em.persist(entity);
			}
			// Save existing Temrin (update)
			else {
				em.merge(entity);
			}
			em.flush();
			em.getTransaction().commit();
			beginTransactionIfNotActive();
		}
		return getAllTermine();
	}

	@Override
	public List<TerminDto> saveOrUpdate(List<TerminDto> termin) {
		if (termin != null && !termin.isEmpty()) {
			for (TerminDto dto : termin) {
				saveOrUpdate(dto);
			}
		}
		return getAllTermine();
	}

	@Override
	public List<TerminDto> remove(Integer id) {
		if (id != null) {
			Termin termin = em.find(Termin.class, id);
			if (termin != null) {
				em.remove(termin);
				em.flush();
				em.getTransaction().commit();
				beginTransactionIfNotActive();
			}
		}
		return getAllTermine();
	}

	private void beginTransactionIfNotActive() {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
	}
}
