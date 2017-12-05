package com.tnas.gft.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TargetDatabase {

	private static TargetDatabase _instance;
	
	public static TargetDatabase getInstance() {
		if (_instance == null) _instance = new TargetDatabase();
		return _instance;
	}
	
	private TargetDatabase() { 
		this.tableBalance = new HashMap<String, Long>();
	}
	
	private Map<String, Long> tableBalance;
	
	public void insertTableBalance(String cnpj, Long balance) {
		this.tableBalance.put(cnpj, balance);
	}
	
	public Set<String> selectAllCNPJTableBalance() {
		return this.tableBalance.keySet();
	}
	
	public Long selectBalanceOfCNPJ(String cnpj) {
		return this.tableBalance.get(cnpj);
	}
	
	public boolean existsCNPJonBalanceTable(String cnpj) {
		return this.tableBalance.containsKey(cnpj);
	}
	
	public String selectCNPJfromCNPJNoVD(String cnpjNoVD) {
		
		for (String cnpj : this.tableBalance.keySet()) {
			if (cnpj.substring(0, 12).equals(cnpjNoVD))
				return cnpj;
		}
		
		return null;
	}
	
	public void dropTableBalance() {
		this.tableBalance.clear();
	}
}
