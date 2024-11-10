package com.user.model;
import java.util.ArrayList;
import java.util.Scanner;

class Cab {
    String cabId;
    String driverName;
    boolean isAvailable;

    Cab(String cabId, String driverName) {
        this.cabId = cabId;
        this.driverName = driverName;
        this.isAvailable = true;
    }
}

// Main class for the cab booking system
public class cabs{
    @Override
	public String toString() {
		return "cab [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	static ArrayList<Cab> cabs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeCabs();

        while (true) {
            System.out.println("Welcome to the Cab Booking System");
            System.out.println("1. View Available Cabs");
            System.out.println("2. Book a Cab");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                viewAvailableCabs();
            } else if (choice == 2) {
                bookCab(scanner);
            } else if (choice == 3) {
                System.out.println("Thank you for using the Cab Booking System.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Initialize cabs with some data
    static void initializeCabs() {
        cabs.add(new Cab("CAB001", "John Doe"));
        cabs.add(new Cab("CAB002", "Alice Smith"));
        cabs.add(new Cab("CAB003", "Bob Johnson"));
    }

    // Display available cabs
    static void viewAvailableCabs() {
        System.out.println("Available Cabs:");
        for (Cab cab : cabs) {
            if (cab.isAvailable) {
                System.out.println("Cab ID: " + cab.cabId + ", Driver: " + cab.driverName);
            }
        }
    }

    // Book a cab for a user
    static void bookCab(Scanner scanner) {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        for (Cab cab : cabs) {
            if (cab.isAvailable) {
                cab.isAvailable = false;
                System.out.println("Cab booked successfully! Cab ID: " + cab.cabId + ", Driver: " + cab.driverName);
                return;
            }
        }
        System.out.println("No cabs available at the moment.");
    }
}
