package com.btgxlm.ibatis.model;

public class Classmate {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	private String classname;
	public String toString(){
		return "classId:"+id+"classname:"+classname; 
	}
}
