package com.tnas.gft.initialstate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitialStateValidationDigit implements InitialStateEmployerService {

	private Map<String, List<Long>> inputData;
	
	public InitialStateValidationDigit() {
		this.inputData = new HashMap<>();
		this.inputData.put("863832180001", Arrays.asList(2L, 0L));
		this.inputData.put("364657490001", Arrays.asList(0L, 1L));
	}
	
	@Override
	public Map<String, List<Long>> getInputData() {
		return this.inputData;
	}
}
