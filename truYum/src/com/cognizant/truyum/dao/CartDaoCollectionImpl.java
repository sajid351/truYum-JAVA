package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	/**
	 * This constructor initialized the Cart as well as the HashMap within the Cart.
	 * Also check if cart of particular user is empty or not if empty then create a
	 * new cart for that user.
	 */
	public CartDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	/**
	 * This method is use to add item to the cart of the particular user by checking
	 * user id.
	 */
	public void addCartItem(long userId, long menuItemId) {

		try {
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			if (userCarts.containsKey(userId)) {
				ArrayList<MenuItem> cartItems = userCarts.get(userId).getMenuItemList();
				cartItems.add(menuItem);

			} else {
				ArrayList<MenuItem> cartMenu = new ArrayList<MenuItem>();
				cartMenu.add(menuItem);
				Cart newCart = new Cart(cartMenu, 0);
				userCarts.put(userId, newCart);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is use to get the all items of a particular user's cart. If cart
	 * is null then throw exception If cart is not null then calculate the total
	 * amount of all items.
	 */
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

		ArrayList<MenuItem> getAll = userCarts.get(userId).getMenuItemList();
		if (getAll.isEmpty()) {
			throw new CartEmptyException();

		} else {
			float value = 0.00f;
			for (MenuItem x : getAll) {
				value = value + x.getPrice();
			}
			userCarts.get(userId).setTotal(value);
		}
		return getAll;
	}

	/**
	 * This method is use to remove item from cart of a particular user by checking
	 * id of that product.
	 */
	public void removeCartItem(long userId, long menuItemId) {

		// TODO Auto-generated method stub
		ArrayList<MenuItem> removeList = userCarts.get(userId).getMenuItemList();
		for (MenuItem x : removeList) {
			if (x.getId() == menuItemId) {
				removeList.remove(removeList.indexOf(x));
				break;
			}
		}
		userCarts.get(userId).setMenuItemList(removeList);

	}

}
