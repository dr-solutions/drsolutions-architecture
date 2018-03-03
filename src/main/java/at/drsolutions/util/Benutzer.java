package at.drsolutions.util;

import java.util.List;

public class Benutzer {
	private String vorname;
	private String nachname;
	private List<Rolle> rollen;
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public List<Rolle> getRollen() {
		return rollen;
	}
	public void setRollen(List<Rolle> rollen) {
		this.rollen = rollen;
	}
}
