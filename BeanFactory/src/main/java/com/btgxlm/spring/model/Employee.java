package com.btgxlm.spring.model;

public class Employee {
	private Worker worker;
	public void EmployWorker(Worker worker){
		this.worker=worker;
		System.out.println("Employing "+worker);
	}
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}
