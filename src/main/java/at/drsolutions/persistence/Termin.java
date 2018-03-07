package at.drsolutions.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = Termin.FIND_ALL, query = "select t from Termin t") })
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "findAllTermine";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "termin_id")
	private int id;

	@Column(name = "bezeichnung")
	private String bezeichnung;

	@Column(name = "beteiligte_person")
	private String beteiligtePersonen;

	@Column(name = "zeitpunkt")
	@Temporal(TemporalType.DATE)
	private Date zeitpunt;

	public Termin(int id, String bezeichnung, String beteiligtePersonen, Date zeitpunt) {
		super();
		this.id = id;
		this.bezeichnung = bezeichnung;
		this.beteiligtePersonen = beteiligtePersonen;
		this.zeitpunt = zeitpunt;
	}

	public Termin() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beteiligtePersonen == null) ? 0 : beteiligtePersonen.hashCode());
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + id;
		result = prime * result + ((zeitpunt == null) ? 0 : zeitpunt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Termin other = (Termin) obj;
		if (beteiligtePersonen == null) {
			if (other.beteiligtePersonen != null)
				return false;
		} else if (!beteiligtePersonen.equals(other.beteiligtePersonen))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (id != other.id)
			return false;
		if (zeitpunt == null) {
			if (other.zeitpunt != null)
				return false;
		} else if (!zeitpunt.equals(other.zeitpunt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Termin [id=" + id + ", bezeichnung=" + bezeichnung + ", beteiligtePersonen=" + beteiligtePersonen
				+ ", zeitpunt=" + zeitpunt + "]";
	}
}
