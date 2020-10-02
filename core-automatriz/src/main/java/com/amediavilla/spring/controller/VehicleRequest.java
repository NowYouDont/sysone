package com.amediavilla.spring.controller;

import java.util.List;

public class VehicleRequest {

	private String carCode;
	private List<String> optionalCodes;
	
	public VehicleRequest(String code, List<String> optionalCodes) {
		super();
		this.carCode = code;
		this.optionalCodes = optionalCodes;
	}
	public String getCarCode() {
		return carCode;
	}
	public void setCarCode(String code) {
		this.carCode = code;
	}
	public List<String> getOptionalCodes() {
		return optionalCodes;
	}
	public void setOptionalCodes(List<String> optionalCodes) {
		this.optionalCodes = optionalCodes;
	}
	
	
}
