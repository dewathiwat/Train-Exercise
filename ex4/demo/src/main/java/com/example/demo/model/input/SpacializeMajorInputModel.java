package com.example.demo.model.input;

import java.util.List;

public class SpacializeMajorInputModel {
	private Long id;
	private String specializeMajorCode;
	private String specializeMajorName;
	private Long specializeSeq;
	private List<SpecializeMinorInputModel> regIoSpecializeMinors;
	private String userIoSpecailize;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSpecializeMajorCode() {
		return specializeMajorCode;
	}
	public void setSpecializeMajorCode(String specializeMajorCode) {
		this.specializeMajorCode = specializeMajorCode;
	}
	public String getSpecializeMajorName() {
		return specializeMajorName;
	}
	public void setSpecializeMajorName(String specializeMajorName) {
		this.specializeMajorName = specializeMajorName;
	}
	public Long getSpecializeSeq() {
		return specializeSeq;
	}
	public void setSpecializeSeq(Long specializeSeq) {
		this.specializeSeq = specializeSeq;
	}
	public List<SpecializeMinorInputModel> getRegIoSpecializeMinors() {
		return regIoSpecializeMinors;
	}
	public void setRegIoSpecializeMinors(List<SpecializeMinorInputModel> regIoSpecializeMinors) {
		this.regIoSpecializeMinors = regIoSpecializeMinors;
	}
	public String getUserIoSpecailize() {
		return userIoSpecailize;
	}
	public void setUserIoSpecailize(String userIoSpecailize) {
		this.userIoSpecailize = userIoSpecailize;
	}
	
}
