package com.java1234.chap06.sec01;

public class CC<T> {

	private T t;
	
	

	public CC(T t) {
		super();
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public void print(){
		System.out.println("t�������ǣ�"+t.getClass().getName());
	}
	
}
