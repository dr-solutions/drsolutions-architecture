package at.drsolutions.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class RandomIntegerOutput extends AbstractOutput {
	private static final long serialVersionUID = 1L;

	private Integer generatedInteger;

	public RandomIntegerOutput() {
	}

	@JsonCreator
	public RandomIntegerOutput(@JsonProperty("generatedInt") int generatedInt) {
		this.generatedInteger = new Integer(generatedInt);
	}

	public Integer getGeneratedInteger() {
		return generatedInteger;
	}

	public void setGeneratedInteger(Integer generatedInteger) {
		this.generatedInteger = generatedInteger;
	}
}
