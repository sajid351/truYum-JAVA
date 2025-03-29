package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	/**
	 * created abstract method which are going to implement in
	 * MenuItemDaoCollectionImpl class.
	 * 
	 * @return
	 */
	public ArrayList<MenuItem> getMenuItemListAdmin();

	public ArrayList<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);

}
