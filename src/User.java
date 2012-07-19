import java.util.ArrayList;

public class User {
    private static int nextLibraryNumber = 1111111;
    private static ArrayList<User> users = new ArrayList<>();

    private String username;
    private String password;
    private int libraryNumber;

    public static User authenticate(String username, String password) {
        for (User user : users) {
            if(user.getUsername().equals(username) &&
                    user.checkPassword(password))
                return user;
        }
        return null;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.libraryNumber = nextLibraryNumber++;
        users.add(this);
    }

    public String getLibraryNumber() {
        return (libraryNumber / 10000) + "-" + (libraryNumber % 10000);
    }

    public String getUsername() {
        return username;
    }


    private boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    public static void cleanUp() {
        nextLibraryNumber = 1111111;
        users = new ArrayList<>();
    }
}
