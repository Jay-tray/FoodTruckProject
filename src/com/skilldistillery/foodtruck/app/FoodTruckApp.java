package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	Scanner sc = new Scanner(System.in);
	FoodTruck[] foodTruck = new FoodTruck[5];

	public static void main(String[] args) {
		FoodTruckApp runApp = new FoodTruckApp();
		runApp.appExec();
	}

	public void truckDetails() {
		System.out.println("Welcome to the newly released Food Truck App!");
		System.out.println(
				"You can rate up to five food trucks at a time!");
		for (int i = 0; i < foodTruck.length; i++) {
			System.out.println("Enter the name of the Food Truck " + (i + 1) + " or type quit!");
			String name = sc.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				System.out.println();
				break;
			}
			System.out.println("Enter the Food Truck's type: ");
			String type = sc.nextLine();

			System.out.println("Enter rating between 1 and 5: ");
			double rating = sc.nextDouble();
			sc.nextLine();

			FoodTruck truck = new FoodTruck(name, type, rating);
			foodTruck[i] = truck;
		}

	}

	public void appExec() {
		truckDetails();
		boolean menu = true;
		while (menu) {
			menuDisplay();
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				listFoodTrucks();
				break;
			case 2:
				averageRating(foodTruck);
				break;
			case 3:
				highestRated();
				break;
			case 4:
				System.out.println("Thanks for using the app! Happy Eating!");
				menu = false;
				break;
			default:
				System.out.println("Please choose a number from the menu!");
			}
		}
	}

	public void menuDisplay() {
		System.out.println();
		System.out.println("Food Truck Menu");
		System.out.println("1. List Food Trucks");
		System.out.println("2. Average User Rating");
		System.out.println("3. Highest Rated Food Truck");
		System.out.println("4. Quit");
	}

	public void listFoodTrucks() {
		for (FoodTruck truckDisplay : foodTruck) {

			if (truckDisplay != null) {
				System.out.println(truckDisplay);
			} else {
				continue;
			}
		}
	}

	public double averageRating(FoodTruck[] foodtruck) {
		double foodTruckRating = 0.0;
		int counter = 0;
		for (int i = 0; i < foodtruck.length; i++) {

			if (foodtruck[i] != null) {
				counter++;
				foodTruckRating += foodtruck[i].getRating();
			}
			if (foodtruck[i] == null) {
				break;
			}
		}

		foodTruckRating = foodTruckRating / counter;
		System.out.println("Your average rating for food is: " + foodTruckRating + " out of 5.");

		return foodTruckRating;

	}

	public void highestRated() {
		double highestRate = 0.0;
		FoodTruck highestRatedTruck = null;
		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] == null) {
				break;
			}
			if (foodTruck[i].getRating() >= highestRate) {
				highestRate = foodTruck[i].getRating();
				highestRatedTruck = foodTruck[i];
			}

		}
		System.out.println("Your highest rated Food Truck is: " + highestRatedTruck + ".");
		System.out.println("Thanks for the recommendation!");
	}
}