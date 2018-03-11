package at.drsolutions.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import at.drsolutions.dao.TerminDAO;
import at.drsolutions.dto.TerminDto;
import at.drsolutions.service.local.TerminServiceLocal;
import at.drsolutions.ws.mapper.TerminMapper;

@Stateless
@Local(TerminServiceLocal.class)
public class TerminService implements TerminServiceLocal {

	TerminDAO dao = new TerminDAO();

	@Override
	public List<TerminDto> getAllTermine() {
		return TerminMapper.mapToDtoList(dao.getAllTermine());
	}

	@Override
	public List<TerminDto> saveOrUpdate(TerminDto termin) {
		return TerminMapper.mapToDtoList(dao.saveOrUpdate(TerminMapper.mapToEntity(termin)));
	}

	@Override
	public List<TerminDto> saveOrUpdate(List<TerminDto> termin) {
		return TerminMapper.mapToDtoList(dao.saveOrUpdateList(TerminMapper.mapToEntityList(termin)));
	}
}
