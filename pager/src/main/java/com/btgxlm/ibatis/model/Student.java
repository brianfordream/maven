package com.btgxlm.ibatis.model;

public class Student {
	private String name;
	private int id;
	private Classmate classmate;
	String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String toString(){
		return "Student name:"+name+"\n\tStudnet id:"+id+"\n\tClass:"+classmate;
	}
	public Classmate getClassmate() {
		return classmate;
	}
	public void setClassmate(Classmate classmate) {
		this.classmate = classmate;
	}
}
