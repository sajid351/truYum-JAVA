package com.cognizant.truyum.model;

import java.util.ArrayList;

public class Cart {
	/**
	 * Instance variable
	 */
	private ArrayList<MenuItem> menuItemList;
	private double total;

	/**
	 * Cart() is a constructor use for initializing values of menu item
	 * 
	 * @param menuItemList
	 *            - list for storing menu Item.
	 * @param total
	 *            - total value of cart.
	 */
	public Cart() {
		
	}
	public Cart(ArrayList<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	/**
	 * Getter and Setter method for each instance variable.
	 * 
	 * @return
	 */
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * overriding toString() to get the values of object.
	 */
	@Override
	public String toString() {
		return "Cart [getMenuItemList()=" + getMenuItemList() + ", getTotal()=" + getTotal() + "]";
	}

}
