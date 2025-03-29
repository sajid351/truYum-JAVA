package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void main(String[] args) {
		/**
		 * Invoking static function.
		 */
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	/**
	 * This method print list of item which are going to add in a cart for a user
	 * whose user Id = 1 and any existing menu item id.
	 * 
	 */
	public static void testAddCartItem() {

		CartDao cartDao = new CartDaoCollectionImpl();

		cartDao.addCartItem(1, 2);

		try {
			ArrayList<MenuItem> cartList = cartDao.getAllCartItems(1);
			System.out.println("Item Added Successfully ");
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "price", "Active",
					"Date of lunch", "Category", "Free Delivery"));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			for (MenuItem item : cartList) {
				System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", item.getName(), item.getPrice(),
						item.isActive(), sdf.format(item.getDateOfLaunch()), item.getCategory(),
						item.isFreeDelivery()));
			}
			System.out.println("\n");
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method print the list of all items present in a cart whose user Id = 1.
	 */
	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();

		try {
			ArrayList<MenuItem> cartItems = cartDao.getAllCartItems(1);
			System.out.println("Item in Cart");
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "price", "Active",
					"Date of lunch", "Category", "Free Delivery"));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			for (MenuItem item : cartItems) {
				System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", item.getName(), item.getPrice(),
						item.isActive(), sdf.format(item.getDateOfLaunch()), item.getCategory(),
						item.isFreeDelivery()));

			}
			System.out.println("\n");

		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The cart item added during testAddCartItem() is removed now and the cart is
	 * empty, due to which the CartEmptyException is thrown. If cart is not empty
	 * then print the remaining cart item.
	 */
	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 2);

		try {
			ArrayList<MenuItem> cartRemaining = cartDao.getAllCartItems(1);
			System.out.println("Is cart Emty");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			if (cartRemaining.isEmpty()) {
				throw new CartEmptyException();
			} else {
				for (MenuItem item : cartRemaining) {
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", item.getName(), item.getPrice(),
							item.isActive(), sdf.format(item.getDateOfLaunch()), item.getCategory(),
							item.isFreeDelivery()));
				}
			}

		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			System.err.println("Cart is empty");
		}

	}

}
