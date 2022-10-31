package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckID = 1; // only static field
	private String name;
	private String type;
	private double rating;
	private int truckID;
	/// NO MAIN

	public FoodTruck(String name, String type, double rating) {
		this.truckID = nextTruckID;
		nextTruckID++;
		this.name = name;
		this.type = type;
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}
	public void setTruckID() {
		truckID++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Food Truck Name: " + name + "\tFood Type: " + type + "\tTruck Rating: " + rating + "\tTruck ID: " + truckID;
		
	}
}
