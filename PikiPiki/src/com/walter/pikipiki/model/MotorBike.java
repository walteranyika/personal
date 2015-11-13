package com.walter.pikipiki.model;

public class MotorBike {
	private String uid,regNo, ownerNames, ownerId, driverNames, driverId, regDate,area, phone ;


	public MotorBike(String uid, String regNo, String ownerNames,String ownerId, String driverNames, String driverId,String regDate, String area, String phone) {
		super();
		this.uid = uid;
		this.regNo = regNo;
		this.ownerNames = ownerNames;
		this.ownerId = ownerId;
		this.driverNames = driverNames;
		this.driverId = driverId;
		this.regDate = regDate;
		this.area = area;
		this.phone = phone;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getOwnerNames() {
		return ownerNames;
	}
	public void setOwnerNames(String ownerNames) {
		this.ownerNames = ownerNames;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getDriverNames() {
		return driverNames;
	}
	public void setDriverNames(String driverNames) {
		this.driverNames = driverNames;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

    public String[] getDataAsArray()
    {
    	return new String[]{ownerNames, ownerId, driverNames, driverId, regDate,area, phone,regNo };
    }	 
}
