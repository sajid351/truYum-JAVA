package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	/**
	 * created abstract method which are going to implement in CartDaoCollectionImpl
	 * class.
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void addCartItem(long userId, long menuItemId);

	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	public void removeCartItem(long userId, long menuItemId);

}
