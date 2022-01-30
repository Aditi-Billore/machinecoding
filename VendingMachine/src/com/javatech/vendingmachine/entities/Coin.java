package com.javatech.vendingmachine.entities;

public enum Coin {
//	Coin will have denomination

	TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);
	
	private int denomination;

	Coin(int price) {
		this.denomination = price;
	}

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	@Override
	public String toString() {
		return "Coin [denomination=" + denomination + "]";
	}
	
}
