package at.drsolutions.dto;

public class RandomIntegerInput extends AbstractInput {
	private static final long serialVersionUID = 1L;

	private Integer maxValue;
	
	public RandomIntegerInput() {}
	
	public RandomIntegerInput(int maxValue) {
		this.maxValue = new Integer(maxValue);
	}
	
	public RandomIntegerInput(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
}
