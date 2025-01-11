package LibraryManagementSystem.src;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        this.isIssued = true;
    }

    public void returnBook() {
        this.isIssued = false;
    }
}

