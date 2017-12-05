package com.tnas.gft.dao;

import com.tnas.gft.database.TargetDatabase;
import com.tnas.gft.model.Balance;

public class BalanceStandaloneDAO implements BalanceDAO {

	@Override
	public void save(Balance balance) {
		TargetDatabase.getInstance().insertTableBalance(balance.getCnpj(), balance.getValue());
	}
	
}
