package LibraryManagementSystem.src;

import java.util.List;

public class UserOperations {
    public void browseBooks(List<Book> books) {
        System.out.println("Browse Books:");
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void searchBook(List<Book> books, String searchQuery) {
        System.out.println("Searching for: " + searchQuery);
        for (Book book : books) {
            if (book.getTitle().contains(searchQuery)) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void issueBook(List<Book> books, String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID) && !book.isIssued()) {
                book.issueBook();
                System.out.println("You have issued: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available for issue.");
    }

    public void returnBook(List<Book> books, String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID) && book.isIssued()) {
                book.returnBook();
                System.out.println("You have returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("This book was not issued to you.");
    }
}

