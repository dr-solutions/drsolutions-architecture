package at.drsolutions.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Termin")
@NamedQueries({ @NamedQuery(name = Termin.FIND_ALL, query = "select t from Termin t") })
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "findAllTermine";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "termin_id")
	private Integer id;

	@Column(name = "bezeichnung")
	private String bezeichnung;

	@Column(name = "ort")
	private String ort;

	@Column(name = "zeitpunkt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date zeitpunkt;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Person_Termin", //
			joinColumns = { @JoinColumn(name = "termin_id") }, //
			inverseJoinColumns = { @JoinColumn(name = "person_id") })
	Set<Person> personen = new HashSet<>();

	public Termin(Integer id, String bezeichnung, String ort, Date zeitpunkt, Set<Person> personen) {
		super();
		this.id = id;
		this.bezeichnung = bezeichnung;
		this.ort = ort;
		this.zeitpunkt = zeitpunkt;
		this.personen = personen;
	}

	public Termin() {
		super();
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

	public Set<Person> getPersonen() {
		return personen;
	}

	public void setPersonen(Set<Person> personen) {
		this.personen = personen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((zeitpunkt == null) ? 0 : zeitpunkt.hashCode());
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
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (personen == null) {
			if (other.personen != null)
				return false;
		} else if (!personen.equals(other.personen))
			return false;
		if (zeitpunkt == null) {
			if (other.zeitpunkt != null)
				return false;
		} else if (!zeitpunkt.equals(other.zeitpunkt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Termin [id=" + id + ", bezeichnung=" + bezeichnung + ", ort=" + ort + ", zeitpunkt=" + zeitpunkt
				+ ", personen=" + personen + "]";
	}
}
