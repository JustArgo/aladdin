package com.maiquan.aladdin_receadd.domain;

import java.io.Serializable;

public class Address implements Serializable{

	
	private static final long serialVersionUID = 7686284901784012660L;

	private int id;
	private String name;
	private int level;
	private int pid;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", level=" + level
				+ ", pid=" + pid + "]";
	}
	
	
	
}
