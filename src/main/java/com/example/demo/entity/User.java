package com.example.demo.entity;

import java.util.Date;

public class User {

    private int id;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private String email;
	private String phoneNo;
	private String status;
	private Date lastActivity;
	private Date createdDtm;
	private String createdBy;
	private Date updatedDtm;
	private String updatedBy;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getLastActivity() {
        return lastActivity;
    }
    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }
    public Date getCreatedDtm() {
        return createdDtm;
    }
    public void setCreatedDtm(Date createdDtm) {
        this.createdDtm = createdDtm;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getUpdatedDtm() {
        return updatedDtm;
    }
    public void setUpdatedDtm(Date updatedDtm) {
        this.updatedDtm = updatedDtm;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
}
