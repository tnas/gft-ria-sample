package com.tnas.gft.initialstate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitialStateEmployeeBalance implements InitialStateEmployerService {

	private Map<String, List<Long>> inputData;
	
	public InitialStateEmployeeBalance() {
		this.inputData = new HashMap<>();
		this.inputData.put("407994500001", Arrays.asList(10L, 5L));
		this.inputData.put("125942160001", Arrays.asList(10L, 10L));
		this.inputData.put("573964610001", Arrays.asList(5L, 10L));
	}
	
	@Override
	public Map<String, List<Long>> getInputData() {
		return this.inputData;
	}
}
