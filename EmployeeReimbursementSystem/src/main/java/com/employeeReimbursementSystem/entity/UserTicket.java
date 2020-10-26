package com.employeeReimbursementSystem.entity;

import com.employeeReimbursementSystem.factory.EntityInterface;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UserTicket implements EntityInterface{
    private String ticketNumber;
	private String empId;
    private String name;
    private String amount;
    private CommonsMultipartFile image;
    private String timeStamp;
    private String approvedBy;
    private String forwardedTo;
    private String remark;
    private String status;
	
	//ticketNumber
	public String getTicketNumber() {
		return ticketNumber;
}
	
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
    }
    //empId
	public String getEmpId() {
		return empId;
}
	
	public void setEmpId(String empId) {
		this.empId = empId;
    }
    //name
	public String getName() {
		return name;
}
	
	public void setName(String name) {
		this.name = name;
    }
    //amount
	public String getAmount() {
		return amount;
}
	
	public void setAmount(String amount) {
		this.amount = amount;
    }
    //image
    public CommonsMultipartFile getImage() {
		return image;
	}
	public void setImage(CommonsMultipartFile image) {

		this.image = image;
    }
    //timestamp
	public String getTimeStamp() {
		return timeStamp;
}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
    }
    //Approved By
	public String getApprovedBy() {
		return approvedBy;
}
	
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
    }
    //Forwarded To
	public String getForwardedTo() {
		return forwardedTo;
}
	
	public void setForwardedTo(String forwardedTo) {
		this.forwardedTo = forwardedTo;
    }
    //Remark
	public String getRemark() {
		return remark;
}
	
	public void setRemark(String remark) {
		this.remark = remark;
    }
    //Status
	public String getStatus() {
		return status;
}
	
	public void setStatus(String status) {
		this.status = status;
    }
    @Override
	public String toString() {
		return "UserTicketCreds [ticketNumber=" + ticketNumber + ", empId=" + empId + ", name=" + name + ", amount=" + amount + ", image=" + image + ", timeStamp=" + timeStamp + ", approvedBy=" + approvedBy+ ", forwardedTo=" + forwardedTo + ", remark=" + remark + ", status=" + status + "]";
	}
}
