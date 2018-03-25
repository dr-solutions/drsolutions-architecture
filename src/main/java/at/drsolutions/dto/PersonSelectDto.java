package at.drsolutions.dto;

import java.io.Serializable;

public class PersonSelectDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer value;
	private String label;

	public PersonSelectDto() {
		super();
	}

	public PersonSelectDto(Integer value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

	public PersonSelectDto(Integer value) {
		super();
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "PersonSelectDto [value=" + value + ", label=" + label + "]";
	}
}
