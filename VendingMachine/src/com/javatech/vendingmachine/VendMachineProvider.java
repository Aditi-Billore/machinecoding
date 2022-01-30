package com.javatech.vendingmachine;

public class VendMachineProvider {
	public VendingMachine getNewMachine() {
		return new VendingMachineImpl();
	}
}
