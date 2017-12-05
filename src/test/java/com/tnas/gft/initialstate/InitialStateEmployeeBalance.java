package com.tnas.gft.initialstate;

import java.util.ArrayList;
import java.util.List;

import com.tnas.gft.model.CNPJ;

public class InitialStateEmployeeBalance implements InitialStateEmployerService {

	private List<CNPJ> listCNPJ;
	
	public InitialStateEmployeeBalance() {
		this.listCNPJ = new ArrayList<>();
		this.listCNPJ.add(new CNPJ("407994500001", 10L, 5L));
		this.listCNPJ.add(new CNPJ("125942160001", 10L, 10L));
		this.listCNPJ.add(new CNPJ("573964610001", 5L, 10L));
	}
	
	@Override
	public List<CNPJ> getListCNPJ() {
		return this.listCNPJ;
	}
}
