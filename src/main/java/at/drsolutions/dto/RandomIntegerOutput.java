package at.drsolutions.dto;

public class RandomIntegerOutput extends AbstractOutput{
	private static final long serialVersionUID = 1L;

	private Integer generatedInteger;
	
	public RandomIntegerOutput() {}
	
	public RandomIntegerOutput(int generatedInt) {
		this.generatedInteger = new Integer(generatedInt);
	}
	
	public RandomIntegerOutput(Integer generatedInteger) {
		this.generatedInteger = generatedInteger;
	}

	public Integer getGeneratedInteger() {
		return generatedInteger;
	}

	public void setGeneratedInteger(Integer generatedInteger) {
		this.generatedInteger = generatedInteger;
	}
}
