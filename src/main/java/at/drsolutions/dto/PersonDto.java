package at.drsolutions.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String vorname;
	private String nachname;
	private String mail;
	private String telefon;

	public PersonDto() {
		super();
	}

	public PersonDto(Integer id, String vorname, String nachname, String mail, String telefon) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.mail = mail;
		this.telefon = telefon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", mail=" + mail
				+ ", telefon=" + telefon + "]";
	}
}
