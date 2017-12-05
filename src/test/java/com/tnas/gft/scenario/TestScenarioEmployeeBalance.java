package com.tnas.gft.scenario;

import org.junit.Test;

import com.tnas.gft.initialstate.InitialStateEmployeeBalance;
import com.tnas.gft.initialstate.InitialStateEmployerService;
import com.tnas.gft.suite.TestRepository;

public class TestScenarioEmployeeBalance extends TestRepository {

	@Override
	protected InitialStateEmployerService getInitialStateEmployerService() {
		return new InitialStateEmployeeBalance();
	}
	
	@Test
	public void testNonGFTEmployeeBalance() {
	}

}
