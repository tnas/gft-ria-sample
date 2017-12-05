package com.tnas.gft.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SourceDatabase {

	private static SourceDatabase _instance;
	
	public static SourceDatabase getInstance() {
		if (_instance == null) _instance = new SourceDatabase();
		return _instance;
	}
	
	private SourceDatabase() {
		this.data = new HashMap<>();
	}
	
	private Map<String, List<Long>> data;
	
	public void loadCNPJData(String cnpjNoVD, Long admitted, Long layoff) {
		List<Long> balance = new ArrayList<Long>();
		balance.add(admitted);
		balance.add(layoff);
		this.data.put(cnpjNoVD, balance);
	}
	
	public void loadCNPJDataChunk(Map<String, List<Long>> chunck) {
		this.data.putAll(chunck);
	}
	
	public Map<String, List<Long>> getAllCNPJData() {
		return this.data;
	}
	
}
