package com.tnas.gft.suite;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.tnas.gft.database.SourceDatabase;
import com.tnas.gft.database.TargetDatabase;
import com.tnas.gft.factory.CNPJFactory;
import com.tnas.gft.initialstate.InitialStateEmployerService;
import com.tnas.gft.model.CNPJ;
import com.tnas.gft.service.EmployerApplicationService;
import com.tnas.gft.service.EmployerStandaloneApplicationService;

/**
 * Respository of Generalized Functional Testings.
 * 
 * @author nascimenthiago@gmail.com
 *
 */
public abstract class TestRepository {

	protected EmployerApplicationService employerService;
	
	public TestRepository() {
		this.employerService = new EmployerStandaloneApplicationService();
		InitialStateEmployerService initialState = getInitialStateEmployerService();
		SourceDatabase.getInstance().loadCNPJDataChunk(initialState.getInputData());
	}

	protected abstract InitialStateEmployerService getInitialStateEmployerService();
	
	@Test
	public void testEmployeeBalance() {
		
		Map<String, List<Long>> data = SourceDatabase.getInstance().getAllCNPJData(); 
		
		for (String strCnpj : data.keySet()) {
			CNPJ cnpj = CNPJFactory.getInstance().build(strCnpj, data.get(strCnpj));
			Long expectedBalance = cnpj.getAdmitted() - cnpj.getLayoff();
			this.employerService.generateBalance(cnpj);
			String cnpjPersisted = TargetDatabase.getInstance().selectCNPJfromCNPJNoVD(cnpj.getValueNoDV());
			Long generatedBalance = TargetDatabase.getInstance().selectBalanceOfCNPJ(cnpjPersisted);
			Assert.assertEquals(expectedBalance, generatedBalance);
		}
		
		Assert.assertEquals(data.size(), TargetDatabase.getInstance().selectAllCNPJTableBalance().size());
	}
	
	@Test
	public void testCNPJValidationDigit() {
		
		Map<String, List<Long>> data = SourceDatabase.getInstance().getAllCNPJData();
		
		for (String strCnpj : data.keySet()) {
			CNPJ cnpj = CNPJFactory.getInstance().build(strCnpj, data.get(strCnpj));
			String expectedCNPJ = addCNPJValidationDigit(cnpj.getValueNoDV());
			this.employerService.generateBalance(cnpj);
			Assert.assertTrue("Expected CNPJ: " + expectedCNPJ, 
					TargetDatabase.getInstance().existsCNPJonBalanceTable(expectedCNPJ));
		}
		
		Assert.assertEquals(data.size(), TargetDatabase.getInstance().selectAllCNPJTableBalance().size());
	}
	
	/**
	 * Plain logic for CNPJ validation digit calculus.
	 * 
	 * @return CNPJ with validation digit
	 */
	private String addCNPJValidationDigit(String cnpjNoVD) {
		
		int lastPos = 11;
		
		int sumPositions = 0;
		String[] parameters = "5,4,3,2,9,8,7,6,5,4,3,2".split(",");
		String[] cnpjNumbers = cnpjNoVD.split("");

		int pos;
		for (pos = 0; pos <= lastPos; ++pos) {
			sumPositions += Integer.valueOf(cnpjNumbers[pos]) * Integer.valueOf(parameters[pos]); 
		}
		
		int rest = sumPositions % 11;
		int firstVD = rest < 2 ? 0 : 11 - rest;
		
		sumPositions = 0;
		parameters = "6,5,4,3,2,9,8,7,6,5,4,3,2".split(",");
		
		for (pos = 0; pos <= lastPos; ++pos) {
			sumPositions += Integer.valueOf(cnpjNumbers[pos]) * Integer.valueOf(parameters[pos]);
		}
		sumPositions += Integer.valueOf(parameters[pos]) * firstVD;
		
		rest = sumPositions % 11;
		int secondVD = rest < 2 ? 0 : 11 - rest;
		
		return cnpjNoVD.concat(String.valueOf(firstVD)).concat(String.valueOf(secondVD));
	}
}
