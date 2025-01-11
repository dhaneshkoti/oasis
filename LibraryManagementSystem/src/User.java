package LibraryManagementSystem.src;

public class User {
    private String userID;
    private String name;

    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }
}

