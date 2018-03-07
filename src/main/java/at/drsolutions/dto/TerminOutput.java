package at.drsolutions.dto;

import java.io.Serializable;
import java.util.Date;

public class TerminOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String bezeichnung;
	private String beteiligtePersonen;
	private Date zeitpunt;

	public TerminOutput(int id, String bezeichnung, String beteiligtePersonen, Date zeitpunt) {
		super();
		this.id = id;
		this.bezeichnung = bezeichnung;
		this.beteiligtePersonen = beteiligtePersonen;
		this.zeitpunt = zeitpunt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBeteiligtePersonen() {
		return beteiligtePersonen;
	}

	public void setBeteiligtePersonen(String beteiligtePersonen) {
		this.beteiligtePersonen = beteiligtePersonen;
	}

	public Date getZeitpunt() {
		return zeitpunt;
	}

	public void setZeitpunt(Date zeitpunt) {
		this.zeitpunt = zeitpunt;
	}
}
