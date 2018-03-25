package at.drsolutions.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TerminDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String bezeichnung;
	private String ort;
	private Date zeitpunkt;
	private List<PersonSelectDto> beteiligtePersonen;

	public TerminDto() {
		super();
	}

	public TerminDto(Integer id, String bezeichnung, String ort, Date zeitpunkt,
			List<PersonSelectDto> beteiligtePersonen) {
		super();
		this.id = id;
		this.bezeichnung = bezeichnung;
		this.ort = ort;
		this.zeitpunkt = zeitpunkt;
		this.beteiligtePersonen = beteiligtePersonen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Date getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public List<PersonSelectDto> getBeteiligtePersonen() {
		return beteiligtePersonen;
	}

	public void setBeteiligtePersonen(List<PersonSelectDto> beteiligtePersonen) {
		this.beteiligtePersonen = beteiligtePersonen;
	}

	@Override
	public String toString() {
		return "TerminDto [id=" + id + ", bezeichnung=" + bezeichnung + ", ort=" + ort + ", zeitpunkt=" + zeitpunkt
				+ ", beteiligtePersonen=" + beteiligtePersonen + "]";
	}
}
