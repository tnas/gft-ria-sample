package com.tnas.gft.dao;

import java.util.List;

import com.tnas.gft.database.SourceDatabase;
import com.tnas.gft.model.CNPJ;

public class CNPJStandaloneDAO implements CNPJDAO {

	@Override
	public List<CNPJ> getAll() {
		return SourceDatabase.getInstance().getAllCNPJ();
	}

}
