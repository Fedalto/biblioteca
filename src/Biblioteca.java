import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Biblioteca bibl = new Biblioteca();
        bibl.welcomeScreen();
        bibl.mainMenu();
    }

    public void welcomeScreen() {
        System.out.println("Welcome to the Bangalore Public Library System");
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1) View all books");
        System.out.println("2) Reserve a book");
        System.out.println("3) Check library number");
        System.out.println("Q) Quit");
        System.out.print("Option: ");
    }

    // Menu loop
    public void mainMenu() {
        String choice;

        do {
            showMenu();
            choice = getMenuChoice();

            selectMenuOption(choice);

        } while (!choice.equalsIgnoreCase("q"));
    }

    public void selectMenuOption(String choice) {
        switch(choice) {
            case "1":
                // View all books
                break;
            case "2":
                // Reserve a book
                break;
            case "3":
                // Check library number
                break;
            case "q":
            case "Q":
                // Quit
                break;
            default:
                System.out.println("Select a valid option!!");
        }
    }

    private String getMenuChoice() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}
