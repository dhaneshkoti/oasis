package ATMSystemImplementation;

import java.util.ArrayList; // Import ArrayList to store transaction history
import java.util.Scanner;  // Import Scanner to take input from the user

// Main class for the ATM system
class ATM {
    // Variables to store user details and account balance
    private String userId = "user123";  // Predefined User ID
    private String userPin = "1234";    // Predefined PIN
    private double balance = 1000.0;    // Starting account balance
    private ArrayList<String> transactionHistory = new ArrayList<>(); // List to keep track of transactions

    // This method starts the ATM system
    public void start() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to take input
        System.out.println("Welcome to the ATM!"); // Greeting message

        // Step 1: Ask the user for their User ID and PIN
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine(); // Take User ID as input

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine(); // Take PIN as input

        // Step 2: Authenticate the user
        if (authenticate(enteredId, enteredPin)) {
            System.out.println("\nLogin Successful!"); // If authentication passes
            showMenu(); // Show the ATM menu
        } else {
            System.out.println("\nInvalid User ID or PIN. Exiting..."); // If authentication fails
        }
        scanner.close(); // Close the scanner after use
    }

    // Method to authenticate the user
    private boolean authenticate(String enteredId, String enteredPin) {
        // Check if entered ID and PIN match the stored credentials
        return userId.equals(enteredId) && userPin.equals(enteredPin);
    }

    // Method to display the ATM menu
    private void showMenu() {
        Scanner scanner = new Scanner(System.in); // Create a new Scanner for menu inputs
        int choice; // Variable to store user's menu choice

        do {
            // Display the menu options
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Take user's choice as input

            // Perform actions based on the user's choice
            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!"); // Exit message
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
        } while (choice != 5); // Keep showing the menu until the user chooses to quit

        scanner.close(); // Close the scanner after use
    }

    // Method to display transaction history
    private void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            // If no transactions have been made
            System.out.println("No transactions available.");
        } else {
            // Print all transactions
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Method to handle withdrawals
    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble(); // Take the amount to withdraw as input

        // Check if the amount is valid and there is enough balance
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Deduct the amount from the balance
            transactionHistory.add("Withdrawn: $" + amount); // Add to transaction history
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance."); // Handle errors
        }
    }

    // Method to handle deposits
    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble(); // Take the amount to deposit as input

        // Check if the amount is valid
        if (amount > 0) {
            balance += amount; // Add the amount to the balance
            transactionHistory.add("Deposited: $" + amount); // Add to transaction history
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid amount. Please try again."); // Handle errors
        }
    }

    // Method to handle fund transfers
    private void transfer(Scanner scanner) {
        System.out.print("Enter recipient's account ID: ");
        String recipient = scanner.next(); // Take recipient's account ID as input
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble(); // Take the amount to transfer as input

        // Check if the amount is valid and there is enough balance
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Deduct the amount from the balance
            transactionHistory.add("Transferred: $" + amount + " to " + recipient); // Add to transaction history
            System.out.println("Transfer successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance."); // Handle errors
        }
    }
}

// Main class to run the program
public class ATMSystem {
    public static void main(String[] args) {
        ATM atm = new ATM(); // Create an instance of the ATM class
        atm.start(); // Start the ATM system
    }
}
