package com.example.demo.model;

import java.util.List;

public class specializeMajorModel {
	private Long specializeMajorId;
	private String specializeMajorName;
	public String getSpecializeMajorName() {
		return specializeMajorName;
	}
	public void setSpecializeMajorName(String specializeMajorName) {
		this.specializeMajorName = specializeMajorName;
	}
	private List<specializeMinorModel> specializeMinor;
	
	public Long getSpecializeMajorId() {
		return specializeMajorId;
	}
	public void setSpecializeMajorId(Long specializeMajorId) {
		this.specializeMajorId = specializeMajorId;
	}

	public List<specializeMinorModel> getSpecializeMinor() {
		return specializeMinor;
	}
	public void setSpecializeMinor(List<specializeMinorModel> specializeMinor) {
		this.specializeMinor = specializeMinor;
	}
}
