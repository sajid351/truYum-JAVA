package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void testAddCartItem() {

		CartDao cartDao = new CartDaoCollectionImpl();

		cartDao.addCartItem(1, 2);

		try {
			ArrayList<MenuItem> cartList = cartDao.getAllCartItems(1);
			System.out.println("Item Added Successfully ");
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "price", "Active", "Date of lunch", "Category", "Free Delivery"));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			for (MenuItem item : cartList) {
				System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", item.getName(), item.getPrice(), item.isActive(), sdf.format(item.getDateOfLaunch()), item.getCategory(), item.isFreeDelivery()));
			}
			
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testGetAllCartItems() {
		CartDaoSqlImpl cartDao = new CartDaoSqlImpl();
		float total = 0.0f;
		//Cart cart = new Cart(null, total);
		try {
			ArrayList<MenuItem> cartItems = cartDao.getAllCartItems((long) 2);
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "Price", "Active", "Date Of Launch", "Category", "Free Delivery"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			for (MenuItem item: cartItems) {
				System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", item.getName(), item.getPrice(), item.isActive(), sdf.format(item.getDateOfLaunch()), item.getCategory(), item.isFreeDelivery()));
				total +=item.getPrice();
			}
			
			System.out.println(total);
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}

	}
	
	

	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem((long) 2, (long) 1);
		try {
			ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems((long) 2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (cartLefts.isEmpty()) {
				throw new CartEmptyException();
			} else {
				for (MenuItem item : cartLefts) {
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", item.getName(), item.getPrice(), item.isActive(), sdf.format(item.getDateOfLaunch()), item.getCategory(), item.isFreeDelivery()));
				}
			}
		} catch (CartEmptyException e) {
			System.err.println("Cart Empty");
		}
	}

	public static void main(String[] args) {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();

	}
}
