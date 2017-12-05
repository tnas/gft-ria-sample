package com.tnas.gft.factory;

import java.util.List;

import com.tnas.gft.model.CNPJ;

public class CNPJFactory {

	private static CNPJFactory _instance;
	
	public static CNPJFactory getInstance() {
		if (_instance == null) _instance = new CNPJFactory();
		return _instance;
	}
	
	private CNPJFactory() { }
	
	public CNPJ build(String cnpj, List<Long> data) {
		return new CNPJ(cnpj, data.get(0), data.get(1));
	}
	
}
