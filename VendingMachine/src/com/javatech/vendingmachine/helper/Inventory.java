package com.javatech.vendingmachine.helper;

import java.util.HashMap;
import java.util.Map;

public class Inventory< T > {

	private Map<T, Integer> inventory = new HashMap<T, Integer>();
	
	public int getQuantity(T item) {
		Integer value = inventory.get(item);
		return value==null?0:value;
	}
	@Override
	public String toString() {
		return "Inventory [inventory=" + inventory + "]";
	}
	public boolean hasItem(T item) {
		return this.getQuantity(item)>0? true:false;
	}
	public void deduct(T item) {
		if(hasItem(item)) {
			Integer value = getQuantity(item);
			this.put(item, value-1);
		}
	}
	public void add(T item) {
		Integer value = getQuantity(item); 
		if( value > 0) {
			this.put(item, value+1);
		}
		else {
			this.put(item, 1);
		}
	}
	public void put(T item, int quantity) {
		inventory.put(item, quantity);
	}
	public void reset() {
		inventory.clear();
	}
}
