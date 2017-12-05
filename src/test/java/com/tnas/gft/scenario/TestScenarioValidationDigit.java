package com.tnas.gft.scenario;

import org.junit.Test;

import com.tnas.gft.initialstate.InitialStateEmployerService;
import com.tnas.gft.initialstate.InitialStateValidationDigit;
import com.tnas.gft.suite.TestRepository;

public class TestScenarioValidationDigit extends TestRepository {
	
	@Override
	protected InitialStateEmployerService getInitialStateEmployerService() {
		return new InitialStateValidationDigit();
	}
	
	@Test
	public void testNonGFTValiationDigit() {
	}


}
