package LibraryManagementSystem.src;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        UserOperations userOps = new UserOperations();
        User user = new User("U001", "John Doe");

        // Sample Books
        admin.addBook("B001", "Java Programming", "Author A");
        admin.addBook("B002", "Data Structures", "Author B");

        while (true) {
            System.out.println("\n1. Admin Operations");
            System.out.println("2. User Operations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. View Books");
                System.out.print("Enter your choice: ");
                int adminChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (adminChoice == 1) {
                    System.out.print("Enter Book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    admin.addBook(bookID, title, author);
                } else if (adminChoice == 2) {
                    System.out.print("Enter Book ID to Delete: ");
                    String bookID = scanner.nextLine();
                    admin.deleteBook(bookID);
                } else if (adminChoice == 3) {
                    admin.viewBooks();
                }
            } else if (choice == 2) {
                System.out.println("\n1. Browse Books");
                System.out.println("2. Search Book");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.print("Enter your choice: ");
                int userChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (userChoice == 1) {
                    userOps.browseBooks(admin.getBooks());
                } else if (userChoice == 2) {
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    userOps.searchBook(admin.getBooks(), query);
                } else if (userChoice == 3) {
                    System.out.print("Enter Book ID to issue: ");
                    String bookID = scanner.nextLine();
                    userOps.issueBook(admin.getBooks(), bookID);
                } else if (userChoice == 4) {
                    System.out.print("Enter Book ID to return: ");
                    String bookID = scanner.nextLine();
                    userOps.returnBook(admin.getBooks(), bookID);
                }
            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}

