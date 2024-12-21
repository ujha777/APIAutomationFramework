package com.api.models.request;

public class SignUpRequest {
	private String  username;
	private String  password;
	private String   email;
	private String  firstName;
	private String  lastName;
	private String   mobileNumber;
	
	
	
	public SignUpRequest(String username, String password, String email, String firstName, String lastName,
			String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "SignUpRequest [username=" + username + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	//Builder Design Pattern Class where class shpould be static
	//should be only methods
	public static class Builder{
		private String  username;
		private String  password;
		private String   email;
		private String  firstName;
		private String  lastName;
		private String   mobileNumber;
		
		public Builder userName(String username) {
			this.username=username;
			//this
			return this;
		}
		
		public Builder password(String password) {
			this.password=password;
			//this
			return this;
		}
		
		public Builder email(String email) {
			this.email=email;
			//this
			return this;
		}
		public Builder firstName(String firstName) {
			this.firstName=firstName;
			//this
			return this;
		}
		public Builder lastName(String lastName) {
			this.lastName=lastName;
			//this
			return this;
		}
		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber=mobileNumber;
			//this
			return this;
		}
		
		
		public SignUpRequest build() {
			SignUpRequest signUpRequest=new SignUpRequest(username, password, email, firstName, lastName, mobileNumber);
			return signUpRequest;
		}
	}
}
