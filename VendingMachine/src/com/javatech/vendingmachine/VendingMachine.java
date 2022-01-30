package com.javatech.vendingmachine;

import com.javatech.vendingmachine.entities.Coin;
import com.javatech.vendingmachine.entities.Product;

public interface VendingMachine {
	public void initialize();
	public void reset();
	public int insertCoin(Coin coin);
	public int selectProdAndGetPrice(Product prod);
	public void giveProductandChange();	
}
