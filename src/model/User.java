package model;

public class User {
    private final String userId;
    private String username;

    private UserBalanceSheet userBalanceSheet;

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.userBalanceSheet = new UserBalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }
}
