package at.drsolutions.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dao.TerminDAO;
import at.drsolutions.dto.TerminDto;
import at.drsolutions.util.IntegrationTest;
import at.drsolutions.ws.mapper.TerminMapper;

public class TerminServiceIT extends IntegrationTest<TerminService> {

	@Override
	public TerminService newInstance() {
		TerminService service = new TerminService();
		service.dao = new TerminDAO();
		service.dao.setEntityManager(getEntityManager());
		return service;
	}

	@Test
	public void testGetAllTermine() {
		List<TerminDto> termine = testedObject.getAllTermine();
		termine.stream().forEach(System.out::println);
		Assert.assertNotNull(termine);
	}

	@Test
	public void testSave() {
		List<TerminDto> termine = testedObject.getAllTermine();
		Assert.assertNotNull(termine);
		int sizeBefore = termine.size();
		TerminDto termin = new TerminDto(null, "Testing 1", "Jakob", new Date());
		System.out.println(new TerminMapper().mapToOutputString(termin));
		termine = testedObject.saveOrUpdate(termin);
		Assert.assertNotNull(termine);
		Assert.assertEquals(sizeBefore + 1, termine.size());
	}

	@Test
	public void testUpdate() {
		List<TerminDto> termine = testedObject.getAllTermine();
		Assert.assertNotNull(termine);
		int sizeBefore = termine.size();
		Assert.assertNotNull(termine);
		Assert.assertTrue(termine.size() > 0);
		TerminDto termin = termine.get(0);
		termin.setBezeichnung("Coding - " + new Random().nextInt(1000));
		termine = testedObject.saveOrUpdate(termin);
		Assert.assertNotNull(termine);
		Assert.assertEquals(sizeBefore, termine.size());
	}
}
