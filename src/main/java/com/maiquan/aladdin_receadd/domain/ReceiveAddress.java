package com.maiquan.aladdin_receadd.domain;

import java.io.Serializable;
import java.util.Date;

public class ReceiveAddress implements Serializable{
	
	private static final long serialVersionUID = -2927215571310338921L;

	private Integer ID;

    private String mqID;

    private String countryID;

    private String provinceID;

    private String cityID;

    private String districtID;

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

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID == null ? null : countryID.trim();
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID == null ? null : provinceID.trim();
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID == null ? null : cityID.trim();
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID == null ? null : districtID.trim();
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