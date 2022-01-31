package com.javatech.vendingmachine.runner;

import java.io.InputStreamReader;
import java.util.Scanner;

import com.javatech.vendingmachine.VendMachineProvider;
import com.javatech.vendingmachine.VendingMachine;
import com.javatech.vendingmachine.entities.Coin;
import com.javatech.vendingmachine.entities.Product;

public class MachineRunner {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine machine = new VendMachineProvider().getNewMachine();
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		System.out.println("Welcome to new vending machine");
		int result;
		do {
			result = machine.showMenu(sc);
			if( result == 1 ) {
				Product prod = machine.showProductMenu(sc);
				int price = machine.selectProdAndGetPrice(prod);
				if(price >0)
					System.out.println("This product costs : " + price + " rupee.");
			}
			else if(result == 2) {
				Coin coin = machine.showCoinMenu(sc);
				if(coin != null)
					machine.insertCoin(coin);
				else
					System.out.println("Select coins only in available denominations");
			}
			else if(result == 3) {
				machine.giveProductandChange();
			}
			else if(result == 4) {
				machine.reset();
			}
			
		}while(result != 5);
	}

}
