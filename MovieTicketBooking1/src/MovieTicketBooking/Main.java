package MovieTicketBooking;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String username;
        String password;

        HashMap<String, String> login = new HashMap<>();
        login.put("abi", "pass");
        login.put("user1", "pass");
        login.put("user2", "pass");

        do {
            System.out.println("******Booking.com*******");
            System.out.println("Login Credential");
            System.out.print("Username: ");
            username = in.nextLine();
            System.out.print("Password: ");
            password = in.nextLine();
            if (authenticate(username, password, login)) {
                System.out.println("Login Successfully.....!");
                Menu menu = new Menu(username, password, login);
                menu.showMenu();
            } else {
                System.out.println("Invalid username or password ........!\nPlease try again.......\n\n\n");
            }

        } while (!authenticate(username, password, login));
    }

    private static boolean authenticate(String username, String password, HashMap<String, String> login) {
        return login.containsKey(username) && login.get(username).equals(password);
    }
}