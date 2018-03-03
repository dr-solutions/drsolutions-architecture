package at.drsolutions.dto;

import java.io.Serializable;

import at.drsolutions.util.Benutzer;

public class AbstractOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	private Benutzer benutzer;

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
}
