package at.drsolutions.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dto.PersonSelectDto;
import at.drsolutions.util.IntegrationTest;

public class PersonBeanIT extends IntegrationTest<PersonBean> {

	@Override
	public PersonBean newInstance() {
		PersonBean service = new PersonBean(getEntityManager());
		return service;
	}

	@Test
	public void testGetAllPersonenSelect() {
		List<PersonSelectDto> personen = testedObject.getAllPersonSelect();
		personen.stream().forEach(System.out::println);
		Assert.assertNotNull(personen);
	}
}
