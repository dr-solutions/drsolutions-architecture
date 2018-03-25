package at.drsolutions.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import at.drsolutions.dto.PersonSelectDto;
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

	@Test
	public void testSave() {
		int random = new Random().nextInt();
		String bezeichnung = "Wanderung " + random;
		List<PersonSelectDto> beteiligtePersonen = Arrays.asList(new PersonSelectDto(Integer.valueOf(1), "René Dolar"),
				new PersonSelectDto(Integer.valueOf(2), "Jakob Kraushofer"));
		TerminDto terminDto = new TerminDto();
		terminDto.setBezeichnung(bezeichnung);
		terminDto.setOrt("Dachstein");
		terminDto.setZeitpunkt(new Date());
		terminDto.setBeteiligtePersonen(beteiligtePersonen);
		int termineAnzBefore = testedObject.getAllTermine().size();
		List<TerminDto> termine = testedObject.saveOrUpdate(terminDto);
		Assert.assertNotNull(termine);
		Assert.assertEquals(termineAnzBefore + 1, termine.size());
		Assert.assertTrue(termine.stream().filter(termin -> bezeichnung.equals(termin.getBezeichnung()))
				.collect(Collectors.toList()).size() > 0);
	}

	@Test
	public void testEdit() {
		List<TerminDto> termine = testedObject.getAllTermine();
		Assert.assertTrue(termine != null && !termine.isEmpty());
		int terminAnzBefore = termine.size();
		TerminDto terminToEdit = termine.stream().filter(t -> t.getBezeichnung().startsWith("Wanderung")).findAny()
				.get();
		terminToEdit.setBezeichnung(terminToEdit.getBezeichnung() + " #edited");
		List<TerminDto> termineAfter = testedObject.saveOrUpdate(terminToEdit);
		Assert.assertNotNull(termineAfter);
		Assert.assertEquals(terminAnzBefore, termine.size());
		Assert.assertTrue(termineAfter.stream().filter(t -> t.getBezeichnung().endsWith("#edited"))
				.collect(Collectors.toList()).size() > 0);
	}

	@Test
	public void testRemove() {
		List<TerminDto> termine = testedObject.getAllTermine();
		Assert.assertTrue(termine != null && !termine.isEmpty());
		int terminAnzBefore = termine.size();
		Optional<TerminDto> terminToDelete = termine.stream().filter(t -> t.getBezeichnung().startsWith("Wanderung"))
				.findAny();
		List<TerminDto> termineAfter = testedObject.remove(terminToDelete.get().getId());
		Assert.assertNotNull(termineAfter);
		Assert.assertEquals(terminAnzBefore - 1, termineAfter.size());
	}
}
