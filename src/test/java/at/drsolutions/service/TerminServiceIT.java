package at.drsolutions.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dto.TerminDto;
import at.drsolutions.util.IntegrationTest;
import at.drsolutions.ws.mapper.TerminMapper;

public class TerminServiceIT extends IntegrationTest<TerminService> {

	@Override
	public TerminService newInstance() {
		TerminService service = new TerminService();
		service = new TerminService();
		service.em = getEntityManager();
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

	@Test
	public void testRemove() {
		List<TerminDto> termine = testedObject.getAllTermine();
		Assert.assertNotNull(termine);
		TerminDto toRemove = termine.get(0);
		Integer idToRemove = toRemove.getId();
		termine = testedObject.remove(idToRemove);
		Assert.assertTrue(
				termine.stream().filter(t -> t.getId() == idToRemove).collect(Collectors.toList()).size() == 0);
	}
}
