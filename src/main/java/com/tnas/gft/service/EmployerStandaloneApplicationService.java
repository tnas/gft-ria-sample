package com.tnas.gft.service;

import com.tnas.gft.dao.BalanceDAO;
import com.tnas.gft.dao.BalanceStandaloneDAO;
import com.tnas.gft.model.Balance;
import com.tnas.gft.model.CNPJ;

import br.com.caelum.stella.DigitoPara;

public class EmployerStandaloneApplicationService implements EmployerApplicationService {

	private BalanceDAO balanceDAO;
	
	public EmployerStandaloneApplicationService() {
		this.balanceDAO = new BalanceStandaloneDAO();
	}
	
	public void generateBalance(CNPJ cnpj) {
		
			Balance balance = new Balance();
			
			String dv = generateCNPJValidationDigit(cnpj.getValueNoDV());
			balance.setCnpj(cnpj.getValueNoDV().concat(dv));
			
			Long balanceValue = calculateEmployeeBalance(cnpj.getAdmitted(), cnpj.getLayoff());
			balance.setValue(balanceValue);
			
			this.balanceDAO.save(balance);
	}
	
	public String generateCNPJValidationDigit(String cnpjNoDV) {
		
		DigitoPara digitoPara = new DigitoPara(cnpjNoDV);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11);
		
		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();
		
		return digito1.concat(digito2);
	}

	public Long calculateEmployeeBalance(Long admitted, Long layoff) {
		return admitted - layoff;
	}
}
