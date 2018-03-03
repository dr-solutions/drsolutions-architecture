package at.drsolutions.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class RandomIntegerInput extends AbstractInput {
	private static final long serialVersionUID = 1L;

	private Integer maxValue;

	public RandomIntegerInput() {
	}

	@JsonCreator
	public RandomIntegerInput(@JsonProperty("maxValue") int maxValue) {
		this.maxValue = new Integer(maxValue);
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
}
