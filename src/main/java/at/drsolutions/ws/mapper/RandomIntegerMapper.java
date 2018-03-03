package at.drsolutions.ws.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.drsolutions.dto.RandomIntegerInput;
import at.drsolutions.dto.RandomIntegerOutput;

public class RandomIntegerMapper extends AbstractMapper<RandomIntegerInput, RandomIntegerOutput> {

	private static Logger LOGGER = LoggerFactory.getLogger(RandomIntegerMapper.class);

	@Override
	public Class<RandomIntegerInput> getInputObjectClass() {
		return RandomIntegerInput.class;
	}

	@Override
	public Class<RandomIntegerOutput> getOutputObjectClass() {
		return RandomIntegerOutput.class;
	}

	@Override
	public Logger getLogger() {
		return LOGGER;
	}
}
