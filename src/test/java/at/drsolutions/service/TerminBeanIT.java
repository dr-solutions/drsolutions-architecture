package at.drsolutions.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dto.TerminDto;
import at.drsolutions.util.IntegrationTest;

public class TerminBeanIT extends IntegrationTest<TerminBean> {

	@Override
	public TerminBean newInstance() {
		TerminBean service = new TerminBean(getEntityManager());
		return service;
	}

	@Test
	public void testGetAllTermine() {
		List<TerminDto> termine = testedObject.getAllTermine();
		termine.stream().forEach(System.out::println);
		Assert.assertNotNull(termine);
	}
}
