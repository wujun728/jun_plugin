package com.java1234.chap03.sec13;

public class Test {

	public static void main(String[] args) {
		// 父类引用指向Dog子类的具体实现
		Animal animal=new Dog();
		animal.say();
		
		// 向下转型
		Dog dog=(Dog) animal;
		dog.say();
		
		// 向下转型 
		Cat cat=(Cat) animal;
		cat.say();
		
	}
}
