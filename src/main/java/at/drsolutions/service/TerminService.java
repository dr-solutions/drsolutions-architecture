package at.drsolutions.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import at.drsolutions.dao.TerminDAO;
import at.drsolutions.dto.TerminOutput;
import at.drsolutions.service.local.TerminServiceLocal;
import at.drsolutions.ws.mapper.TerminMapper;

@Stateless
@Local(TerminServiceLocal.class)
public class TerminService implements TerminServiceLocal {

	TerminDAO dao = new TerminDAO();

	@Override
	public List<TerminOutput> getAllTermine() {
		return TerminMapper.mapToDtoList(dao.getAllTermine());
	}
}
