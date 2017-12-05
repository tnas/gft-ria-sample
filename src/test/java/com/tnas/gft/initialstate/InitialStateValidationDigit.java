package com.tnas.gft.initialstate;

import java.util.ArrayList;
import java.util.List;

import com.tnas.gft.model.CNPJ;

public class InitialStateValidationDigit implements InitialStateEmployerService {

	private List<CNPJ> listCNPJ;
	
	public InitialStateValidationDigit() {
		this.listCNPJ = new ArrayList<>();
		this.listCNPJ.add(new CNPJ("863832180001", 2L, 0L));
		this.listCNPJ.add(new CNPJ("364657490001", 0L, 1L));
	}
	
	@Override
	public List<CNPJ> getListCNPJ() {
		return this.listCNPJ;
	}
}
