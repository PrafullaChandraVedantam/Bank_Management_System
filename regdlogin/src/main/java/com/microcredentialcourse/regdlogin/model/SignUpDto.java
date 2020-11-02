package com.microcredentialcourse.regdlogin.model;

import javax.persistence.Column;

public class SignUpDto {

	@Column(nullable = false)
	private String userName;

	private String password;
	private String emailId;
	private String address;
	private String state;
	private String country;
	private String phoneNum;
	private String panNum;
	private String accntType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	public String getAccntType() {
		return accntType;
	}

	public void setAccntType(String accntType) {
		this.accntType = accntType;
	}

	public SignUpDto(String userName, String password, String emailId, String address, String state, String country,
			String phoneNum, String panNum, String accntType) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.address = address;
		this.state = state;
		this.country = country;
		this.phoneNum = phoneNum;
		this.panNum = panNum;
		this.accntType = accntType;
	}

	@Override
	public String toString() {
		return "SignUp [userName=" + userName + ", password=" + password + ", emailId=" + emailId + ", address="
				+ address + ", state=" + state + ", country=" + country + ", phoneNum=" + phoneNum + ", panNum="
				+ panNum + ", accntType=" + accntType + "]";
	}

	public SignUpDto() {
		super();
	}

}
