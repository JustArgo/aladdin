package com.maiquan.aladdin_receadd.domain;

import java.io.Serializable;
import java.util.Date;

public class ReceiveAddress implements Serializable{
	
	private static final long serialVersionUID = -2927215571310338921L;

	private Integer ID;

    private String mqID;

    private Integer countryID;

    private Integer provinceID;

    private Integer cityID;

    private Integer districtID;

    private String address;

    private String isDefault;

    private String recName;

    private String recMobile;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Date delTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getMqID() {
        return mqID;
    }

    public void setMqID(String mqID) {
        this.mqID = mqID == null ? null : mqID.trim();
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName == null ? null : recName.trim();
    }

    public String getRecMobile() {
        return recMobile;
    }

    public void setRecMobile(String recMobile) {
        this.recMobile = recMobile == null ? null : recMobile.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

	@Override
	public String toString() {
		return "ReceiveAddress [ID=" + ID + ", mqID=" + mqID + ", countryID="
				+ countryID + ", provinceID=" + provinceID + ", cityID="
				+ cityID + ", districtID=" + districtID + ", address="
				+ address + ", isDefault=" + isDefault + ", recName=" + recName
				+ ", recMobile=" + recMobile + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", delTime=" + delTime + "]";
	}
    
    
}