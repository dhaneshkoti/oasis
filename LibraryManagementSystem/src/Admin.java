package LibraryManagementSystem.src;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Book> books = new ArrayList<>();

    public void addBook(String bookID, String title, String author) {
        books.add(new Book(bookID, title, author));
        System.out.println("Book added: " + title);
    }

    public void deleteBook(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                books.remove(book);
                System.out.println("Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void viewBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}

