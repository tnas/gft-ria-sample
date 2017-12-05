package com.tnas.gft.database;

import java.util.ArrayList;
import java.util.List;

import com.tnas.gft.model.CNPJ;


public class SourceDatabase {

	private static SourceDatabase _instance;
	
	public static SourceDatabase getInstance() {
		if (_instance == null) _instance = new SourceDatabase();
		return _instance;
	}
	
	private SourceDatabase() {
		this.cnpjList = new ArrayList<>();
	}
	
	private List<CNPJ> cnpjList;
	
	public void loadCNPJ(CNPJ cnpj) {
		this.cnpjList.add(cnpj);
	}
	
	public void loadListCNPJ(List<CNPJ> list) {
		this.cnpjList.addAll(list);
	}
	
	public List<CNPJ> getAllCNPJ() {
		return this.cnpjList;
	}
	
	public CNPJ getCNPJ() {
		if (this.cnpjList != null && (!this.cnpjList.isEmpty()))
			return this.cnpjList.get(0);
		return null;
	}
}
