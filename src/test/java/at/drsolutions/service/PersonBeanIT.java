package at.drsolutions.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dto.PersonDto;
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

	@Test
	public void testGetAllPersonen() {
		List<PersonDto> personen = testedObject.getAllPersonen();
		personen.stream().forEach(System.out::println);
		Assert.assertNotNull(personen);
	}

	@Test
	public void testSave() {
		int random = new Random().nextInt(10000001);
		PersonDto person = new PersonDto();
		person.setMail("test.test@dr-solutions.at");
		person.setTelefon(random + "");
		person.setVorname("Thomas");
		person.setNachname("Heiderer");
		int perosnenAnzBefore = testedObject.getAllPersonen().size();
		List<PersonDto> personen = testedObject.saveOrUpdate(person);
		Assert.assertNotNull(personen);
		Assert.assertEquals(perosnenAnzBefore + 1, personen.size());
		Assert.assertTrue(personen.stream().filter(p -> p.getTelefon().equals(random + "")).collect(Collectors.toList())
				.size() > 0);
	}

	@Test
	public void testEdit() {
		List<PersonDto> personen = testedObject.getAllPersonen();
		Assert.assertTrue(personen != null && !personen.isEmpty());
		int personenAnzBefore = personen.size();
		PersonDto personToEdit = personen.stream().filter(p -> p.getMail().equals("test.test@dr-solutions.at"))
				.findAny().get();
		personToEdit.setNachname(personToEdit.getNachname() + " #edited");
		List<PersonDto> personenAfter = testedObject.saveOrUpdate(personToEdit);
		Assert.assertNotNull(personenAfter);
		Assert.assertEquals(personenAnzBefore, personenAfter.size());
		Assert.assertTrue(personenAfter.stream().filter(p -> p.getNachname().endsWith("#edited"))
				.collect(Collectors.toList()).size() > 0);
	}

	@Test
	public void testRemove() {
		List<PersonDto> personen = testedObject.getAllPersonen();
		Assert.assertTrue(personen != null && !personen.isEmpty());
		int personenAnzBefore = personen.size();
		PersonDto personToDelete = personen.stream().filter(p -> p.getMail().equals("test.test@dr-solutions.at"))
				.findAny().get();
		List<PersonDto> personenAfter = testedObject.remove(personToDelete.getId());
		Assert.assertNotNull(personenAfter);
		Assert.assertEquals(personenAnzBefore - 1, personenAfter.size());
	}
}
