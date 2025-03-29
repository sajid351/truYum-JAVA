package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> menuItemList;

	/**
	 * MenuItemDaoCollectionImpl() is a constructor use to set values of menu item
	 * by invoking constructor of MenuItem class.
	 */
	public MenuItemDaoCollectionImpl() {
		super();
		/**
		 * If list is null then add item in menu list.
		 */
		if (menuItemList == null || menuItemList.isEmpty()) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(01l, "Sandwich", 99.0f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(02l, "Burger", 129.0f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(03l, "Pizza", 149.0f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(04l, "French Fries", 57.0f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(05l, "Chocolate Brownie", 32.0f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true));
		}

	}

	/**
	 * It is use to return a list of item that are visible to admin.
	 */
	public ArrayList<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	/**
	 * It is use to return a list of item that are visible to customer.
	 */
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> filterList = new ArrayList<>();

		for (MenuItem item : menuItemList) {
			Date lunchDate = item.getDateOfLaunch();
			// String today = new Date();
			Date today = new Date();

			if (lunchDate.before(today) || lunchDate.equals(today)) {

				if (item.isActive()) {
					filterList.add(item);
				}
			}
		}
		return filterList;

	}

	/**
	 * This function is use to modify list of menu item.
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#modifyMenuItem(com.cognizant.truyum.model.MenuItem)
	 */
	public void modifyMenuItem(MenuItem menuItem) {

		for (MenuItem item : menuItemList) {

			if (item.equals(menuItem)) {
				item.setName(menuItem.getName());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setFreeDelivery(menuItem.isFreeDelivery());
			}
		}
	}

	/**
	 * This function is use to get the list of menu item.
	 */
	public MenuItem getMenuItem(long menuItemId) {

		for (MenuItem item : menuItemList) {

			if (item.getId() == menuItemId) {
				return item;
			}
		}
		return null;
	}

}
