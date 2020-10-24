package com.employeeReimbursementSystem.entity;

import com.employeeReimbursementSystem.factory.EntityInterface;

public class UsersCreds  implements EntityInterface{
	
private String empId;
private String password;
private String email;
private String  role;
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
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
public String  getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "UsersCreds [empId=" + empId + ", password=" + password + ", email=" + email + ", role=" + role + "]";
}


}
