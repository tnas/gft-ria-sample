package com.tnas.gft.service;

import com.tnas.gft.model.CNPJ;

public interface EmployerApplicationService {

	
	/**
	 * Persist full balance for all persisted CNPJ.
	 * 
	 * @param balance
	 */
	public void generateBalance(CNPJ cnpj);
	
	/**
	 * Implements the business rule R1 of the article concrete example.
	 * 
	 * @param cnpjNoDV - CNPJ without validation digit.
	 * 
	 * @return String - CNPJ with validation digit.
	 */
	String generateCNPJValidationDigit(String cnpjNoDV);
	
	
	/**
	 * Implements the business rule R2 of the article concrete example.
	 * A negative balance implies that a zero value is retorned.
	 * 
	 * @param admitted - Number of admitted
	 * @param layoff - Number of layed off
	 * 
	 * @return Long - Employee balance.
	 */
	Long calculateEmployeeBalance(Long admitted, Long layoff);
}
