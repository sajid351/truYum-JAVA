package com.cognizant.truyum.model;

import java.util.Date;

public class MenuItem {
	/**
	 * Instance variable
	 */
	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	/**
	 * MenuItem() is a constructor use for initializing values of menu item
	 * 
	 * @param id
	 *            - ID of item.
	 * @param name
	 *            - name of item.
	 * @param price
	 *            - price of item.
	 * @param active
	 *            - is item available or not.
	 * @param dateOfLaunch
	 *            - when we took item.
	 * @param category
	 *            - category of item.
	 * @param freeDelivery
	 *            - is item available for free delivery.
	 */
	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	/**
	 * Getter and Setter method for each instance variable
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	/**
	 * overriding toString() to get the values of object.
	 */
	@Override
	public String toString() {
		return "MenuItem [getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", isActive()=" + isActive() + ", getDateOfLaunch()=" + getDateOfLaunch() + ", getCategory()="
				+ getCategory() + ", isFreeDelivery()=" + isFreeDelivery() + "]";
	}

	/**
	 * overriding equals() to which checks for equality based on the ‘id’ attribute
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
