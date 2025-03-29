package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl {
	private static final String INSERT_QUERY = "insert into cart (userid, menuid) values(?,?)";
	private static final String JOIN_QUERY = "select * from menu JOIN cart ON menu.menuid = cart.menuid where cart.userid = ?";
	private static final String DELETE_QUERY = "delete from  cart where userid = ? AND menuid = ?";
	
	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.execute();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		
		Connection con = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = con.prepareStatement(JOIN_QUERY);
			stmt.setLong(1, userId);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				long id = rs.getLong("userid");
				String name  = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date dateOfLaunch = rs.getDate("date_of_lunch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem menu  = new MenuItem(id, name, price, act, dateOfLaunch, category, free);
				menuItemList.add(menu);
				
			}
			
			
	
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}

		return menuItemList;
	}
	
	public void removeCartItem(long userId, long menuItemId)
	{
		Connection con = ConnectionHandler.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(DELETE_QUERY);
			stmt.setLong(1,userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
	

