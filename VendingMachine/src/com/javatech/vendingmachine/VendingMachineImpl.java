package com.javatech.vendingmachine;

import com.javatech.vendingmachine.entities.Coin;
import com.javatech.vendingmachine.entities.Product;
import com.javatech.vendingmachine.helper.Inventory;

public class VendingMachineImpl implements VendingMachine {
	Inventory<Product> productInventory = new Inventory<Product>();
	Inventory<Coin> cashInventory = new Inventory<Coin>();
	Product currentProduct;
	int currentAmount = 0;
	int totalSales = 0;
	int MAX_VALUE = 5;
	
	@Override
	public void initialize() {
		for(Coin c: Coin.values()) {
			cashInventory.put(c, MAX_VALUE);
		}
		for(Product p: Product.values()) {
			productInventory.put(p, MAX_VALUE);
		}
		currentProduct = null;
		currentAmount = 0;
		totalSales = 0;
	}

	@Override
	public void reset() {
		cashInventory.reset();
		productInventory.reset();
		currentProduct = null;
		currentAmount = 0;
		totalSales = 0;		
	}

	@Override
	public int insertCoin(Coin coin) {
		cashInventory.add(coin);
		currentAmount += coin.getDenomination();	
		System.out.println("Available balance : "+ currentAmount);
		return currentAmount;
	}

	@Override
	public int selectProdAndGetPrice(Product prod) {
		if(productInventory.hasItem(prod)) {
			currentProduct = prod;
			return prod.getPrice();
		}
		else
		{
			System.out.println("The product is no longer available in store, please select another.");
			return 0;
		}
			
	}

	@Override
	public void giveProductandChange() {
		if(isPaymentFull()) {
			if(isChangeAvailable()) {
				System.out.println("Dispenced product: " + currentProduct.getName());
				productInventory.deduct(currentProduct);
				System.out.println("Please collect cash and product");
			}
			else {
				System.out.println("Change not available, please try some other product or retrieve cash");
			}
		}
		else {
			System.out.println("Payment not sufficient, please add more cash");
		}
	}
	
	public boolean isChangeAvailable() {
		int balance = currentAmount - currentProduct.getPrice();
		System.out.println("Balance to be returned " + balance);
		return balance>0? hasChange(balance):true;
	}
	
	public boolean hasChange(int balance) {
//		check the balance required to return.. process cash and return in that denomination
		Inventory<Coin> toReturn = new Inventory<Coin>();
		while(balance>0) {
			if(balance>= Coin.HUNDRED.getDenomination() && 
					cashInventory.hasItem(Coin.HUNDRED)) {
				toReturn.add(Coin.HUNDRED);
				cashInventory.deduct(Coin.HUNDRED);
				balance -= Coin.HUNDRED.getDenomination();
			}
			else if(balance>= Coin.FIFTY.getDenomination() && 
					cashInventory.hasItem(Coin.FIFTY)) {
				toReturn.add(Coin.FIFTY);
				cashInventory.deduct(Coin.FIFTY);
				balance -= Coin.FIFTY.getDenomination();
			}
			else if(balance>= Coin.TWENTY.getDenomination() && 
					cashInventory.hasItem(Coin.TWENTY)) {
				toReturn.add(Coin.TWENTY);
				cashInventory.deduct(Coin.TWENTY);
				balance -= Coin.TWENTY.getDenomination();
			}
			else if(balance>= Coin.TEN.getDenomination() && 
					cashInventory.hasItem(Coin.TEN)) {
				toReturn.add(Coin.TEN);
				cashInventory.deduct(Coin.TEN);
				balance -= Coin.TEN.getDenomination();
			}
			else {
//				no cash present to give return change to user
				return false;
			}
		}
		System.out.println("Dispencing change:");
		System.out.println(toReturn);
		return true;
	}
	
	public boolean isPaymentFull() {
		return currentAmount>=currentProduct.getPrice();
	}


}
