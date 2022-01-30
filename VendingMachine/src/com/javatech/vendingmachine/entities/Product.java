package com.javatech.vendingmachine.entities;

public enum Product {
//	product should have  a name and price associated with it
//	initially there will be only cans
	
	PEPSI("PEPSI", 20), COKE("COKE", 30), REDBULL("REDBULL", 40);
	
	private String name;
	private int price;
	
	private Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	
}
