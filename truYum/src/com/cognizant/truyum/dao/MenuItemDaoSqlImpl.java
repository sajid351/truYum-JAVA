package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	private static final String SELECT_QUERY = "select * from menu";
	private static final String SELECT_QUERY_WITH_TWO_CONDITION = "select * from menu where active=? AND date_of_lunch < ?";
	private static final String SELECT_QUERY_FILTER_WITH_MENUID = "select * from menu where menuid=?";

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("menuid");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date dateOfLaunch = rs.getDate("date_of_lunch");
				String category = rs.getString("category");
				String freeDelivery = rs.getString("free_delivery");
				boolean act = false;
				if (active.equalsIgnoreCase("yes")) {
					act = true;
				}
				boolean free = false;
				if (freeDelivery.equalsIgnoreCase("yes")) {
					free = true;
				}
				MenuItem menu = new MenuItem(id, name, price, act, dateOfLaunch, category, free);
				menuItemList.add(menu);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		finally {
			
			try {
				rs.close();
				stmt.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return menuItemList;

	}

	public ArrayList<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		Date todayDate = new Date();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(SELECT_QUERY_WITH_TWO_CONDITION);
			stmt.setString(1, "yes");
			stmt.setDate(2, new java.sql.Date(todayDate.getTime()));

			rs = stmt.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("menuid");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date dateOfLaunch = rs.getDate("date_of_lunch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if (active.equalsIgnoreCase("yes")) {
					act = true;
				}
				boolean free = false;
				if (free_delivery.equalsIgnoreCase("yes")) {
					free = true;
				}
				MenuItem menu = new MenuItem(id, name, price, act, dateOfLaunch, category, free);
				menuItemListCust.add(menu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			try {
				rs.close();
				stmt.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return menuItemListCust;

	}

	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem menu = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = con.prepareStatement(SELECT_QUERY_FILTER_WITH_MENUID);
			stmt.setLong(1, menuItemId);

			rs = stmt.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("menuid");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date dateOfLaunch = rs.getDate("date_of_lunch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if (active.equalsIgnoreCase("yes")) {
					act = true;
				}
				boolean free = false;
				if (free_delivery.equalsIgnoreCase("yes")) {
					free = true;
				}
				menu = new MenuItem(id, name, price, act, dateOfLaunch, category, free);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			
			try {
				rs.close();
				stmt.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return menu;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement stmt = null;
		
		long id = menuItem.getId();
		String name = menuItem.getName();
		float price = menuItem.getPrice();
		boolean active = menuItem.isActive();
		
		java.sql.Date d = (java.sql.Date) new Date(menuItem.getDateOfLaunch().getTime());
		String category = menuItem.getCategory();
		boolean free = menuItem.isFreeDelivery();
		String act;
		if (active == true) {
			act = "Yes";
		} else {
			act = "No";
		}
		String fd;
		if (free == true) {
			fd = "Yes";
		} else {
			fd = "No";
		}
		final String query = "update menu"
				+ "set name = ?, price = ?, active = ?, date_of_lunch = ?, category = ?, free_delivery = ?"
				+ "where menuid = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setFloat(2, price);
			stmt.setString(3, act);
			stmt.setDate(4, d);
			stmt.setString(5, category);
			stmt.setString(6, fd);
			stmt.setLong(7, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				stmt.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
