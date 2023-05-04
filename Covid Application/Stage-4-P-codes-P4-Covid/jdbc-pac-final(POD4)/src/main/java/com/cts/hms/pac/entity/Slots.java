package com.cts.hms.pac.entity;

import java.util.Date;

import com.itextpdf.text.pdf.PdfPCell;

public class Slots {

	private  Long id;
	private Date slotDate;
	private String slotTime;
	private String userName;
	private  String centerName;
	private  String vType;
	private Long aadharNumber;
	

	public Slots() { }

	public Slots(Long id, Date slotdate, String slotTime, String userName, String centerName, String vType,Long aadharNumber) {
		super();
		this.id = id;
		this.slotDate = slotdate;
		this.slotTime = slotTime;
		this.userName = userName;
		this.centerName = centerName;
		this.vType = vType;
		this.aadharNumber=aadharNumber;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public  String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	public String getVType() {
		return vType;
	}

	public void setVType(String vType) {
		this.vType = vType;
	}
	public Long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Override
	public String toString() {
		return "Slots [id=" + id + ", slotDate=" + slotDate + ", slotTime=" + slotTime + ", userName=" + userName
				+ ", centerName=" + centerName + ", vType=" + vType + ", aadharNumber=" + aadharNumber + "]";
	}
	
	
	
}
