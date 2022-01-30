package com.javatech.vendingmachine.runner;

import java.io.InputStreamReader;
import java.util.Scanner;

import com.javatech.vendingmachine.VendMachineProvider;
import com.javatech.vendingmachine.VendingMachine;
import com.javatech.vendingmachine.entities.Coin;
import com.javatech.vendingmachine.entities.Product;

public class MachineRunner {

	static Scanner sc;

	public static Coin getCoinFromUser() {		
		int result;		
		System.out.println("PRESS 1: To Select TEN");
		System.out.println("PRESS 2: To Select TWENTY");
		System.out.println("PRESS 3: To Select FIFTY");
		System.out.println("PRESS 3: To Select HUNDRED");
		
		result = sc.nextInt();
		if(result == 1) {
			return Coin.TEN;
		}
		else if(result == 2) {
			return Coin.TWENTY;
		}
		else if(result == 3) {
			return Coin.FIFTY;
		}
		else if(result == 3) {
			return Coin.HUNDRED;
		}
		return null;
	}

	public static Product getProductFromUser() {		
		int result;		
		System.out.println("PRESS 1: To Select COKE");
		System.out.println("PRESS 2: To Select PEPSI");
		System.out.println("PRESS 3: To Select REDBULL");
		
		result = sc.nextInt();
		if(result == 1) {
			return Product.COKE;
		}
		else if(result == 2) {
			return Product.PEPSI;
		}
		else if(result == 3) {
			return Product.REDBULL;
		}
		return null;
	}
	
	public static int menu() {
		int result = 0;
		
		System.out.println("PRESS 1: To Select a product");
		System.out.println("PRESS 2: To Add Cash");
		System.out.println("PRESS 3: To Retrive product");
		System.out.println("PRESS 4: To Exit");
		
		result = sc.nextInt();
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine machine = new VendMachineProvider().getNewMachine();
		machine.initialize();		
		sc = new Scanner(new InputStreamReader(System.in));
		System.out.println("Welcome to new vending machine");
		int result;
		do {
			result = menu();
			if( result == 1 ) {
				Product prod = getProductFromUser();
				int price = machine.selectProdAndGetPrice(prod);
				if(price >0)
					System.out.println("This product costs : " + price + " rupee.");
			}
			else if(result == 2) {
				Coin coin = getCoinFromUser();
				if(coin != null)
					machine.insertCoin(coin);
				else
					System.out.println("Select coins only in available denominations");
			}
			else if(result == 3) {
				machine.giveProductandChange();
			}
			
		}while(result != 4);
	}

}
