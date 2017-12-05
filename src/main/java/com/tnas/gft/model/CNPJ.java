package com.tnas.gft.model;

import lombok.Data;

@Data
public class CNPJ {

	private String valueNoDV;
	private Long admitted;
	private Long layoff;
	
	public CNPJ(String value, Long admitted, Long layoff) {
		this.valueNoDV = value;
		this.admitted  = admitted;
		this.layoff    = layoff;
	}
}
