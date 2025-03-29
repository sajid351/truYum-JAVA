package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Invoking static function.
		 */
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

	/**
	 * This method is use to print the list of item for admin.
	 */
	public static void testGetMenuItemListAdmin() {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		menuItems = menuItemDao.getMenuItemListAdmin();

		System.out.println("Menu item for Admin");
		System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "price", "Active", "Date of lunch",
				"Category", "Free Delivery"));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		for (MenuItem items : menuItems) {

			System.out.println(
					String.format("%-20s%-20s%-20s%-20s%-20s%-20s", items.getName(), items.getPrice(), items.isActive(),
							sdf.format(items.getDateOfLaunch()), items.getCategory(), items.isFreeDelivery()));
		}
		System.out.println("\n");
	}

	/**
	 * This method is use to print the list of item for customer.
	 */
	public static void testGetMenuItemListCustomer() {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		menuItems = menuItemDao.getMenuItemListCustomer();

		System.out.println("Menu item for Customer");
		System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "price", "Active", "Date of lunch",
				"Category", "Free Delivery"));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		for (MenuItem items : menuItems) {

			System.out.println(
					String.format("%-20s%-20s%-20s%-20s%-20s%-20s", items.getName(), items.getPrice(), items.isActive(),
							sdf.format(items.getDateOfLaunch()), items.getCategory(), items.isFreeDelivery()));
		}
		System.out.println("\n");

	}

	/**
	 * This method is use to print the list of modify or updated item.
	 */
	public static void testModifyMenuItem() {

		MenuItem menuItem = new MenuItem(02l, "Burger", 200.0f, true, DateUtil.convertToDate("23/12/2017"),
				"Main Course", false);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		if (menuItemDao.getMenuItem(menuItem.getId()).equals(menuItem)) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "price", "Active",
					"Date of lunch", "Category", "Free Delivery"));
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s", menuItem.getName(), menuItem.getPrice(),
					menuItem.isActive(), sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(),
					menuItem.isFreeDelivery()));
		}
		System.out.println("Modification Done Successfully");

	}

}
