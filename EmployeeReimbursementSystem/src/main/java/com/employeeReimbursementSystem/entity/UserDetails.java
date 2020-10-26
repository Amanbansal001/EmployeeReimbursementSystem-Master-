package com.employeeReimbursementSystem.entity;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.employeeReimbursementSystem.factory.EntityInterface;

public class UserDetails implements EntityInterface{
	private String empId;
	private String role;
	private String password;
	private String designation;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNo;
	private String email;
	private String currentAddress;
	private byte []file;
	private CommonsMultipartFile uploadfile;
	private String imageDisplay;
	

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public CommonsMultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(CommonsMultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getImageDisplay() {
		return imageDisplay;
	}
	public void setImageDisplay(String imageDisplay) {
		this.imageDisplay = imageDisplay;
	}
	@Override
	public String toString() {
		return "UserDetails [empId=" + empId + ", role=" + role + ", password=" + password + ", designation="
				+ designation + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", currentAddress=" + currentAddress + ", file="
				+ Arrays.toString(file) + ", uploadfile=" + uploadfile + ", imageDisplay=" + imageDisplay + "]";
	}
	public  UserDetails editUserDetail(String empId2) {
	
		return null;
	}

	
}
