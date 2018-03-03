package at.drsolutions.persistence;

import java.util.Date;

public class Termin {
	
	private String ort;
	private String bezeichnung;
	private Date datumUhrzeit;
	
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public Date getDatumUhrzeit() {
		return datumUhrzeit;
	}
	public void setDatumUhrzeit(Date datumUhrzeit) {
		this.datumUhrzeit = datumUhrzeit;
	}
}
