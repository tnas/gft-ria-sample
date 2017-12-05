package com.tnas.gft.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tnas.gft.scenario.TestScenarioEmployeeBalance;
import com.tnas.gft.scenario.TestScenarioValidationDigit;


@RunWith(Suite.class)
@SuiteClasses({
	TestScenarioValidationDigit.class,
	TestScenarioEmployeeBalance.class
	})
public class GFTTestSuite {

}
