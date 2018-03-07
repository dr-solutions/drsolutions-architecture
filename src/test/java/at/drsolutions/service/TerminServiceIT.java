package at.drsolutions.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dao.TerminDAO;
import at.drsolutions.dto.TerminOutput;
import at.drsolutions.util.IntegrationTest;

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
		List<TerminOutput> termine = testedObject.getAllTermine();
		Assert.assertNotNull(termine);
		Assert.assertEquals(2, termine.size());
	}
}
