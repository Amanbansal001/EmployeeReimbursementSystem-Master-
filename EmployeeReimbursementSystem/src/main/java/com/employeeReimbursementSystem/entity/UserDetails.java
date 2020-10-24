package com.employeeReimbursementSystem.entity;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.employeeReimbursementSystem.factory.EntityInterface;

public class UserDetails implements EntityInterface{
	private String name;
	private String email;
	private String mobileNo;
	private CommonsMultipartFile uploadfile;
	private byte []file;
	private String imageDisplay;
	
	public String getImageDisplay() {
		return imageDisplay;
	}
	public void setImageDisplay(String imageDisplay) {
		this.imageDisplay = imageDisplay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public CommonsMultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(CommonsMultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", uploadfile="
				+ uploadfile + ", file=" + Arrays.toString(file) + "]";
	}
	


}
