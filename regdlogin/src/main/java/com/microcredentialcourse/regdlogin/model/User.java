package com.microcredentialcourse.regdlogin.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "CUST")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int regd_id;
	@Column(unique = true)
	@NotBlank(message = "Please enter the customername")
	@Size(min = 4, max = 12, message = "Username must be of min 4 and max 12 characters")
	private String userName;
	@Column
	@JsonIgnore
	@NotBlank(message = "Please enter the password")
	private String password;
	@Column(unique = true)
	@Email(message = "Enter valid email address")
	@NotBlank(message = "Please enter the emailId")
	private String emailId;
	@Column
	@NotBlank(message = "Please enter the address")
	private String address;
	@Column
	private long accntNum = Random();
	@Column
	@NotBlank(message = "Please enter name of the state")
	private String state;
	@Column
	@NotBlank(message = "Please enter name of the country")
	private String country;
	@Column
	@Size(min = 0, max = 10)
	@Pattern(regexp = "(^$|[0-9]{10})")
	@NotBlank(message = "Please enter the valid phone number")
	private String phoneNum;
	@Column(unique = true)
	@Size(min = 10, max = 10, message = "Pan card consists of only 10 characters")
	@NotBlank(message = "Please enter the pan card number")
	private String panNum;
	@Column
	@NotBlank(message = "Please enter the account type")
	private String accntType;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRegd_id() {
		return regd_id;
	}

	public void setRegd_id(int regd_id) {
		this.regd_id = regd_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public long getAccntNum() {
		return accntNum;
	}

	public void setAccntNum(long accntNum) {
		this.accntNum = accntNum;
	}
	
	

	public User(int regd_id,
			@NotBlank(message = "Please enter the username") @Size(min = 4, max = 12, message = "Username must be of min 4 and max 12 characters") String userName,
			@NotBlank(message = "Please enter the password") String password,
			@Email(message = "Enter valid email address") @NotBlank(message = "Please enter the emailId") String emailId,
			@NotBlank(message = "Please enter the address") String address, long accntNum,
			@NotBlank(message = "Please enter name of the state") String state,
			@NotBlank(message = "Please enter name of the country") String country,
			@Size(min = 0, max = 10) @Pattern(regexp = "(^$|[0-9]{10})") @NotBlank(message = "Please enter the valid phone number") String phoneNum,
			@Size(min = 10, max = 10, message = "Pan card consists of only 10 characters") @NotBlank(message = "Please enter the pan card number") String panNum,
			@NotBlank(message = "Please enter the account type") String accntType) {
		super();
		this.regd_id = regd_id;
		this.accntNum = accntNum;
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

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [regd_id=" + regd_id + ", userName=" + userName + ", password=" + password + ", emailId=" + emailId
				+ ", address=" + address + ", accntNum=" + accntNum + ", state=" + state + ", country=" + country
				+ ", phoneNum=" + phoneNum + ", panNum=" + panNum + ", accntType=" + accntType + "]";
	}
	
	

	

	private long Random() {
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;

		// return a long between smallest and biggest (+1 to include biggest as well
		// with the upper bound)
		long random = ThreadLocalRandom.current().nextLong(smallest, biggest + 1);
		return random;
	}

}
